package boostcourse1.boostcourse1spring.courseV3_v2.domain.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductMemoryRepository implements ProductRepository {
    private static final Map<Long, Product> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }
}
