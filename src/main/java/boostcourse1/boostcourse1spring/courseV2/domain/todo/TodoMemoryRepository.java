package boostcourse1.boostcourse1spring.courseV2.domain.todo;

import java.util.*;

public class TodoMemoryRepository implements TodoRepository {
    private static final Map<Long, Todo> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void delete(Long todoId) {
        store.remove(todoId);
    }

    @Override
    public void update(Long todoId, Todo updateParam) {
        Todo findTodo = findById(todoId).get();
        findTodo.setSequence(updateParam.getSequence());
        findTodo.setType(updateParam.getType());
    }

    @Override
    public Optional<Todo> findById(Long todoId) {
        return Optional.ofNullable(store.get(todoId));
    }

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
