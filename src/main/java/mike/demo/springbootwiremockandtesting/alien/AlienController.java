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
    public List<AlienEntity> getAliens() {
        return alienRepository.fetchSomeAliens();
    }

    @GetMapping("/aliens/standard")
    public Iterable<AlienEntity> getAliensStandard() {
        return alienRepository.findAll();
    }
}
