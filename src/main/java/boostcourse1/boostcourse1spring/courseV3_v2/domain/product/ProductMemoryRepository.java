package boostcourse1.boostcourse1spring.courseV3_v2.domain.product;

import java.util.*;

public class ProductMemoryRepository implements ProductRepository {
    private static final Map<Long, Product> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Product> findExhibitionAll() {
        return null;
    }

    @Override
    public List<Product> findMusicalAll() {
        return null;
    }

    @Override
    public List<Product> findConcertAll() {
        return null;
    }

    @Override
    public List<Product> findClassicAll() {
        return null;
    }

    @Override
    public List<Product> findTheaterAll() {
        return null;
    }
}
