package mike.demo.springbootwiremockandtesting.alien;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue
    private int id;
    private String skillName;

    @ManyToMany(mappedBy = "skills")
    private Set<Alien> aliens;
}
