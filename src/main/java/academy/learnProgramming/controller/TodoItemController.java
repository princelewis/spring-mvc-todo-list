package academy.learnProgramming.controller;


import academy.learnProgramming.model.TodoData;
import academy.learnProgramming.util.Mappings;
import academy.learnProgramming.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // == model attribute

    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // handler methods
    // http://localhost:8080/todo-list
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
