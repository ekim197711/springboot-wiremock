package mike.demo.springbootwiremockandtesting.spacestation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SpaceStationProtocolDroid {
    private final String SPACESTATION_SERVER = "http://localhost:9999";
    private final RestTemplate restTemplate = new RestTemplate();

    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }

    public Boolean isSpaceshipAllowedToDock(String spaceshipId) {
        return restTemplate.getForObject(SPACESTATION_SERVER + "//{spaceshipId}/spaceships/dock", Boolean.class, spaceshipId);
    }
}
