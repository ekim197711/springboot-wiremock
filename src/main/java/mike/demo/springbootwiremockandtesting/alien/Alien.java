package mike.demo.springbootwiremockandtesting.alien;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private AlienOrigin origin;
    @ManyToMany
    @JoinTable(name = "alien_skill", joinColumns = @JoinColumn(name = "alien_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills;
}
