package mike.demo.springbootwiremockandtesting.alien;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AlienRepository extends CrudRepository<Alien, Long> {


    @Query("""
                    SELECT A from Alien A        
                    LEFT JOIN FETCH A.skills S
                    LEFT JOIN FETCH A.origin O
            """)
    public List<Alien> fetchSomeAliens();
}
