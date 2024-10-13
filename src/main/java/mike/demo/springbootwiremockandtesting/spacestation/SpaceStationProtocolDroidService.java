package mike.demo.springbootwiremockandtesting.spacestation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SpaceStationProtocolDroidService {
    private final String SPACESTATION_SERVER = "http://localhost:9999";
    private final RestTemplate restTemplate = new RestTemplate();


    public SpaceShipAllowedResponse isSpaceshipAllowedToDock(String spaceshipId) {
        try {
            return restTemplate.getForObject(SPACESTATION_SERVER + "//{spaceshipId}/spaceships/dock",
                    SpaceShipAllowedResponse.class,
                    spaceshipId);
        } catch (HttpClientErrorException httpClientErrorException) {
            if (httpClientErrorException.getStatusCode().value() == 404) {
                return SpaceShipAllowedResponse.builder()
                        .isAllowedToDock(false)
                        .spaceshipId(spaceshipId)
                        .error(true)
                        .errorMessage("The spaceship was not found!")
                        .build();
            } else {
                throw new RuntimeException(httpClientErrorException);
            }
        }
    }
}
