package ibf2022.paf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7

@Service
public class TodoService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    public Optional<User> findUserByUsername(String userName) {
        return userRepository.findUserByUsername(userName);
    }

    // upsert task, to check if user exist first
    // if not create user before inserting tasks
    // to use @transaction
    @Transactional(rollbackFor = Exception.class)
    public Integer upsertTask(String userName, List<Task> taskList) {

        int taskCount = 0;

        Optional<User> searchResult = userRepository.findUserByUsername(userName);
        if (searchResult.isEmpty()) {
            User u = new User();
            u.setUsername(userName);

            String generatedId = userRepository.insertUser(u);
        }
        for (Task t : taskList) {
            taskRepository.insertTask(t);
            taskCount++;
        }
        return taskCount;
    }

}
