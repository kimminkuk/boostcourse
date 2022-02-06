package boostcourse1.boostcourse1spring.courseV2.domain.todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Todo save(Todo todo);
    List<Todo> findAll();

    Optional<Todo> findByTitle(String title);
}
