package academy.learnProgramming.controller;


import academy.learnProgramming.model.TodoData;
import academy.learnProgramming.service.TodoItemService;
import academy.learnProgramming.util.Mappings;
import academy.learnProgramming.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attribute

    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // handler methods
    // http://localhost:8080/todo-list
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
