package mike.demo.springbootwiremockandtesting.spaceship;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public final class SpaceshipDto {
    private Integer id;
    private String name;
    private Integer crewMembers;
    private Double fuelPercentage;
}
