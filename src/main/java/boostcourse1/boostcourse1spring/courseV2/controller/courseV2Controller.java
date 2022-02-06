package boostcourse1.boostcourse1spring.courseV2.controller;

import boostcourse1.boostcourse1spring.courseV2.domain.todo.Todo;
import boostcourse1.boostcourse1spring.courseV2.domain.todo.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/basic-v2/HOME")
@RequiredArgsConstructor
public class courseV2Controller {
    private final TodoService todoService;

    @GetMapping
    public String todos(Model model) {
        List<Todo> todos = todoService.findTodos();
        model.addAttribute("todos", todos);
        return "basic-v2/HOME";
    }
}
