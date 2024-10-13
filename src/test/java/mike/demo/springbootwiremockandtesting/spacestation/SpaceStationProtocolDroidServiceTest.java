package mike.demo.springbootwiremockandtesting.spacestation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


@SpringBootTest
@EnableWireMock({
        @ConfigureWireMock(port = 9999, name = "wm-spacestation-proxy")
})
public class SpaceStationProtocolDroidServiceTest {

    @Autowired
    private SpaceStationProtocolDroidService spaceStationProtocolDroid;

    @BeforeEach
    void init() throws JsonProcessingException {
        stubFor(get(WireMock.urlEqualTo("/myship1/spaceships/dock"))
                .willReturn(ok(
                        new ObjectMapper().writeValueAsString(
                                SpaceShipAllowedResponse.builder().isAllowedToDock(true)
                                        .spaceshipId("myship1").build())).withHeader(
                        HttpHeaders.CONTENT_TYPE, "application/json"
                ))
        );
        stubFor(get(WireMock.urlEqualTo("/myship2/spaceships/dock"))
                .willReturn(ok(
                        new ObjectMapper().writeValueAsString(
                                SpaceShipAllowedResponse.builder().isAllowedToDock(false)
                                        .spaceshipId("myship2").build())).withHeader(
                        HttpHeaders.CONTENT_TYPE, "application/json"
                ))
        );
    }

    @Test
    public void isSpaceshipAllowedToDock() {
        String spaceShip1 = "myship1";
        SpaceShipAllowedResponse response1 = spaceStationProtocolDroid.isSpaceshipAllowedToDock(spaceShip1);
        Assertions.assertThat(response1.isAllowedToDock()).isTrue();
        Assertions.assertThat(response1.getSpaceshipId()).isEqualTo(spaceShip1);
    }

    @Test
    public void isSpaceshipAllowedToDockExample2() {
        String spaceShip = "myship2";
        SpaceShipAllowedResponse response = spaceStationProtocolDroid.isSpaceshipAllowedToDock(spaceShip);
        Assertions.assertThat(response.isAllowedToDock()).isFalse();
        Assertions.assertThat(response.getSpaceshipId()).isEqualTo(spaceShip);
    }

    @Test
    public void isSpaceshipAllowedToDockNotFound() {
        String spaceShip = "shipdoesnotexist";
        SpaceShipAllowedResponse response = spaceStationProtocolDroid.isSpaceshipAllowedToDock(spaceShip);
        Assertions.assertThat(response.isAllowedToDock()).isFalse();
        Assertions.assertThat(response.getSpaceshipId()).isEqualTo(spaceShip);
        Assertions.assertThat(response.isError()).isTrue();
        Assertions.assertThat(response.getErrorMessage()).isEqualTo("The spaceship was not found!");
    }
}