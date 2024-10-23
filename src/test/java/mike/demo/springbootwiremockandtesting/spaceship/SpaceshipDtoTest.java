package mike.demo.springbootwiremockandtesting.spaceship;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

public class SpaceshipDtoTest {

    //    SpaceshipDto dto = new SpaceshipDto();
//        dto.setName("Spaceship");
//        dto.setCrewMembers(200);
//        dto.setFuelPercentage(88.2);
//        dto.setId(12);
    @Test
    public void testSpaceshipDto() {
        EqualsVerifier.simple().forClass(SpaceshipDto.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT,
                        Warning.ALL_FIELDS_SHOULD_BE_USED)
                .verify()
        ;

    }
}