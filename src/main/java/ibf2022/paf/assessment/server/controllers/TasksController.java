package ibf2022.paf.assessment.server.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.services.TodoService;

// TODO: Task 4, Task 8
@RestController
public class TasksController {

    @Autowired
    TodoService todoService;

    @PostMapping (path = "/task" , consumes = "application/x-www-form-urlencoded")
    public ModelAndView saveTodoList (@RequestBody MultiValueMap<String, String> requestParams) {

        List<Task> taskList = new ArrayList<>();
        String userName = requestParams.getFirst("username");

        int index = 0;
        while (requestParams.containsKey("description-" + index)) {
            Task t = new Task();
            t.setDescription((requestParams.getFirst("description-" + index)).replaceAll("%20", " "));
            t.setPriority(requestParams.getFirst("priority-" + index));
            t.setDueDate(requestParams.getFirst("dueDate-" + index));

            taskList.add(t);
            index++;
        }
        
        Integer taskCountUpdated = todoService.upsertTask(userName, taskList);

        ModelAndView mv = new ModelAndView();
        if (taskCountUpdated < 1) {
            mv.setViewName("error");
            mv.setStatus(HttpStatusCode.valueOf(500));
            return mv;
        }

        mv.setViewName("result");
        mv.setStatus(HttpStatusCode.valueOf(200));
        mv.addObject("taskCount", taskCountUpdated);
        mv.addObject("username", userName);
        return mv;
    }

}
