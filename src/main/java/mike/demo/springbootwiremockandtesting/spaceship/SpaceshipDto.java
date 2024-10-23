package mike.demo.springbootwiremockandtesting.spaceship;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
public final class SpaceshipDto {
    private Integer id;
    private String name;
    private Integer crewMembers;
    private Double fuelPercentage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceshipDto dto = (SpaceshipDto) o;
        return Objects.equals(name, dto.name) && Objects.equals(crewMembers,
                dto.crewMembers) && Objects.equals(fuelPercentage, dto.fuelPercentage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, crewMembers, fuelPercentage);
    }
}
