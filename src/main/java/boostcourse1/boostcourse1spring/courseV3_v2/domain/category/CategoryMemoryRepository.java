package boostcourse1.boostcourse1spring.courseV3_v2.domain.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryMemoryRepository implements CategoryRepository {
    private static final Map<Long, Category> store = new HashMap<>();
    private static final Long sequence = 0L;


    @Override
    public List<Category> findAll() {
        return new ArrayList<>(store.values());
    }
}
