package mike.demo.springbootwiremockandtesting.alien;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SkillEntity {

    @Id
    @GeneratedValue
    private int id;
    private String skillName;

    @JsonIgnore
    @ManyToMany(mappedBy = "skillEntities")
    private Set<AlienEntity> aliens;
}
