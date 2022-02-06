package boostcourse1.boostcourse1spring;

import boostcourse1.boostcourse1spring.courseV2.domain.todo.TodoRepository;
import boostcourse1.boostcourse1spring.courseV2.domain.todo.TodoService;
import boostcourse1.boostcourse1spring.courseV2.repository.JdbcTemplateTodoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class todoServiceConfig {
    private final DataSource dataSource;

    public todoServiceConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public TodoService todoService() {
        return new TodoService(todoRepository());
    }
    @Bean
    public TodoRepository todoRepository() {
        return new JdbcTemplateTodoRepository(dataSource);
    }
}
