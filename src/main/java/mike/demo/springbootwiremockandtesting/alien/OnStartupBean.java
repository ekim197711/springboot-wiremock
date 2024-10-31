package mike.demo.springbootwiremockandtesting.alien;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class OnStartupBean {
    private final AlienRepository alienRepository;
    private final SkillRepository skillRepository;

    @PostConstruct
    public void init() {
        Skill running = skillRepository.save(Skill.builder().skillName("Running")
                .build());
        Skill jumping = skillRepository.save(Skill.builder().skillName("Jumping")
                .build());
        alienRepository.save(Alien.builder()
                .origin(AlienOrigin.Humanoid)
                .age(30)
                .name("Mike")
                .skills(Set.of(running, jumping))
                .build());
        log.info("Alien created...");
    }
}
