package mike.demo.springbootwiremockandtesting.spaceship;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/spaceship")
public class SpaceShipRestController {

    @GetMapping("/findall")
    public List<SpaceshipDto> findAll() {
        List<SpaceshipDto> spaceships = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            spaceships.add(SpaceshipDto.builder()
                    .id(new Random().nextInt())
                    .crewMembers(new Random().nextInt() % 10)
                    .fuelPercentage(new Random().nextDouble() % 100)
                    .build());
        }
        return spaceships;
    }
}
