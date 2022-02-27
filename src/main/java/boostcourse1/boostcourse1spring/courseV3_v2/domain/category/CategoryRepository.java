package boostcourse1.boostcourse1spring.courseV3_v2.domain.category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
}
