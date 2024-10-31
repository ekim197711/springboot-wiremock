package mike.demo.springbootwiremockandtesting.alien;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AlienController {
    private final AlienRepository alienRepository;

    @GetMapping("/aliens")
    public List<Alien> getAliens() {
        return alienRepository.fetchSomeAliens();
    }
}
