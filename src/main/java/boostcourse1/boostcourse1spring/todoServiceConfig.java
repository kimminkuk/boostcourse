package boostcourse1.boostcourse1spring;

import boostcourse1.boostcourse1spring.courseV2.domain.todo.TodoRepository;
import boostcourse1.boostcourse1spring.courseV2.domain.todo.TodoService;
import boostcourse1.boostcourse1spring.courseV2.repository.JdbcTemplateTodoRepository;
import boostcourse1.boostcourse1spring.courseV3.domain.guestbook.GuestbookRepository;
import boostcourse1.boostcourse1spring.courseV3.domain.guestbook.GuestbookService;
import boostcourse1.boostcourse1spring.courseV3.domain.log.LogRepository;
import boostcourse1.boostcourse1spring.courseV3.domain.log.LogService;
import boostcourse1.boostcourse1spring.courseV3.repository.JT_GuestbookRepository;
import boostcourse1.boostcourse1spring.courseV3.repository.JT_LogRepository;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.category.CategoryRepository;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.category.CategoryService;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.product.ProductRepository;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.product.ProductService;
import boostcourse1.boostcourse1spring.courseV3_v2.repository.JT_CategoryRepository;
import boostcourse1.boostcourse1spring.courseV3_v2.repository.JT_ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class todoServiceConfig {
    private final DataSource dataSource;

    public todoServiceConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //Project 2
    @Bean
    public TodoService todoService() {
        return new TodoService(todoRepository());
    }
    @Bean
    public TodoRepository todoRepository() {
        return new JdbcTemplateTodoRepository(dataSource);
    }

    //Project 3-1
    @Bean
    public LogService logService() {
        return new LogService(logRepository());
    }

    @Bean
    public LogRepository logRepository() {
        return new JT_LogRepository(dataSource);
    }

    @Bean
    public GuestbookService guestbookService() {
        return new GuestbookService(guestbookRepository());
    }

    @Bean
    public GuestbookRepository guestbookRepository() {
        return new JT_GuestbookRepository(dataSource);
    }

    //Project 3-2
    @Bean
    ProductService productService() {
        return new ProductService(productRepository());
    }

    @Bean
    public ProductRepository productRepository() {
        return new JT_ProductRepository(dataSource);
    }

    @Bean
    CategoryService categoryService() {
        return new CategoryService(categoryRepository());
    }
    @Bean
    public CategoryRepository categoryRepository() {
        return new JT_CategoryRepository(dataSource);
    }
}
