package mike.demo.springbootwiremockandtesting.alien;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AlienRepository extends CrudRepository<AlienEntity, Long> {


    @Query("""
                    SELECT A from AlienEntity A        
                    LEFT JOIN FETCH A.skillEntities S                   
            """)
    public List<AlienEntity> fetchSomeAliens();
}
