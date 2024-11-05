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
        SkillEntity running = skillRepository.save(SkillEntity.builder().skillName("Running")
                .build());
        SkillEntity jumping = skillRepository.save(SkillEntity.builder().skillName("Jumping")
                .build());
        alienRepository.save(AlienEntity.builder()
                .origin(AlienOrigin.Humanoid)
                .age(30)
                .name("Mike")
                .skillEntities(Set.of(running, jumping))
                .build());
        log.info("Alien created...");
    }
}
