package mike.demo.springbootwiremockandtesting.spacestation;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.wiremock.spring.ConfigureWireMock;
import org.wiremock.spring.EnableWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


@SpringBootTest
@EnableWireMock({
        @ConfigureWireMock(port = 9999, name = "wm-spacestation-proxy")
})
public class SpaceStationProtocolDroidTest {

    @Autowired
    private SpaceStationProtocolDroid spaceStationProtocolDroid;

//    @Rule public WireMockRule wireMockRule = new WireMockRule(options().dynamicPort());

    @BeforeEach
    void init() {
        stubFor(get(WireMock.urlEqualTo("/myship1/spaceships/dock"))
                .willReturn(ok("true")));
    }

    @Test
    public void isSpaceshipAllowedToDock() {
        Boolean myship1 = spaceStationProtocolDroid.isSpaceshipAllowedToDock("myship1");
        Assertions.assertThat(myship1).isTrue();

    }
}