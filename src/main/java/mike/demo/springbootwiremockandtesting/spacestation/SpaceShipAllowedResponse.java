package mike.demo.springbootwiremockandtesting.spacestation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpaceShipAllowedResponse {
    private boolean isAllowedToDock;
    private String spaceshipId;
    private boolean error;
    private String errorMessage;
}
