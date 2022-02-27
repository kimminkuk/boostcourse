package boostcourse1.boostcourse1spring.courseV3_v2.domain.category;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findCategorys() {
        return categoryRepository.findAll();
    }
}
