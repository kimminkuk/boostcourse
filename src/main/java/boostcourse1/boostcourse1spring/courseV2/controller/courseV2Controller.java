package boostcourse1.boostcourse1spring.courseV2.controller;

import boostcourse1.boostcourse1spring.courseV2.domain.todo.Todo;
import boostcourse1.boostcourse1spring.courseV2.domain.todo.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/basic-v2")
@RequiredArgsConstructor
public class courseV2Controller {
    private final TodoService todoService;

    @GetMapping("/HOME")
    public String todos(Model model) {
        List<Todo> todos = todoService.findTodos();
        List<Todo> todos1 = new ArrayList<Todo>();
        List<Todo> todos2 = new ArrayList<Todo>();
        List<Todo> todos3 = new ArrayList<Todo>();
        for (Todo todo : todos) {
            int sequence = todo.getSequence();
            switch (sequence) {
                case 1:
                    todos1.add(todo);
                    break;
                case 2:
                    todos2.add(todo);
                    break;
                case 3:
                    todos3.add(todo);
                    break;
                default:
                    break;
            }
        }
        model.addAttribute("todos1", todos1);
        model.addAttribute("todos2", todos2);
        model.addAttribute("todos3", todos3);
        model.addAttribute("todos", todos);

        return "basic-v2/HOME";
    }

    @GetMapping("/TODO")
    public String TodoForm(Model model) {

        return "basic-v2/TODO";
    }

    //This Redirect Action in Ajax
    @PostMapping("/TODO")
    public void TodoAdd(Model model,
                          @ModelAttribute("todo") Todo todo,
                          @RequestParam("param1") String title,
                          @RequestParam("param2") String name,
                          @RequestParam("param3") int sequence) {
        String type = String.valueOf(sequence) + "순위";
        Date date = new Date();
        Todo savedTodo = new Todo(title, name, sequence, type, date);
        Todo todo1 = todoService.saveTodoService(savedTodo);
        return;
    }

    @GetMapping("/todo/{todoId}")
    public String todo(@PathVariable long todoId, Model model) {
        return "basic-v2/check";
    }
}
