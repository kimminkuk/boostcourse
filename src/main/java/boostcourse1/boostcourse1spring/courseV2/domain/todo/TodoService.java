package boostcourse1.boostcourse1spring.courseV2.domain.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo saveTodoService(Todo todo) {
        validateDuplicateTodo(todo);
        return todoRepository.save(todo);
    }

    public Long join(Todo todo) {
        validateDuplicateTodo(todo);
        todoRepository.save(todo);
        return todo.getId();
    }

    public List<Todo> findTodos() {
        return todoRepository.findAll();
    }

    private void validateDuplicateTodo(Todo todo) {
        todoRepository.findByTitle(todo.getTitle())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 할 일입니다.");
                });
    }
}
