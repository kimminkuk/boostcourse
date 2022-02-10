package boostcourse1.boostcourse1spring.courseV2.domain.todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Optional<Todo> findById(Long id);
    void update(Long todoId, Todo updateParam);
    Todo save(Todo todo);
    List<Todo> findAll();
    Optional<Todo> findByTitle(String title);
}
