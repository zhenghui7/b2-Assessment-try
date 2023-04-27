package ibf2022.paf.assessment.server.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;
import static ibf2022.paf.assessment.server.repositories.DBQueries.*;

// TODO: Task 6
@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertTask (Task task) {
        
        boolean update = jdbcTemplate.update(INSERT_TASK, task.getDescription(), task.getPriority(), task.getDueDate() ) > 0;
    }
    
}
