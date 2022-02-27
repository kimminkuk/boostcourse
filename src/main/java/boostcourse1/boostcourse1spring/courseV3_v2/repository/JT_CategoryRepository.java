package boostcourse1.boostcourse1spring.courseV3_v2.repository;

import boostcourse1.boostcourse1spring.courseV3_v2.domain.category.Category;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.category.CategoryRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JT_CategoryRepository implements CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public JT_CategoryRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query("select * from category", categoryRowMapper());
    }

    private RowMapper<Category> categoryRowMapper() {
        return (rs, rowNum) -> {
            Category category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            return category;
        };
    }
}
