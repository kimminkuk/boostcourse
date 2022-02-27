package boostcourse1.boostcourse1spring.courseV3_v2.domain.product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
