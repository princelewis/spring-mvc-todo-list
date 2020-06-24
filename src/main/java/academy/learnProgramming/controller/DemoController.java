package academy.learnProgramming.controller;

import academy.learnProgramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
//@RequestMapping
public class DemoController {

    private DemoService demoservice;

    @Autowired
    public DemoController(DemoService demoService){
        this.demoservice = demoService;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    //http://localhost:8080/todo-list/welcome
    //http://localhost:8080/todo-list/welcome?user=Tim
    //prefix + name + suffix
    // /WEB-INF/view/welcome.jsp
    @GetMapping("welcome")
    public String welcome(@RequestParam(value = "user") String user,
                          @RequestParam int age, Model model) {

        model.addAttribute("age", age);
        model.addAttribute("hello",demoservice.getHelloMessage(user));
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        log.info("welcomeMessage() called");
        return demoservice.getWelcomeMessage();
    }
}
