package boostcourse1.boostcourse1spring.courseV2.domain.todo;

import java.util.*;

public class TodoMemoryRepository implements TodoRepository {
    private static final Map<Long, Todo> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Todo save(Todo todo) {
        todo.setId(++sequence);
        store.put(todo.getId(), todo);
        return todo;
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        return store.values().stream()
                .filter(findTitle -> findTitle.getTitle().equals(title))
                .findAny();
    }

    public void clearStore() {
        store.clear();
    }
}
