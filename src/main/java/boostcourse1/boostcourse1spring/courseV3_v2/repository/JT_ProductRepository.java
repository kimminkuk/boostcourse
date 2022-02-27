package boostcourse1.boostcourse1spring.courseV3_v2.repository;

import boostcourse1.boostcourse1spring.courseV3_v2.domain.product.Product;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.product.ProductRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JT_ProductRepository implements ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public JT_ProductRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("select * from product", productRowMapper());
    }

    private RowMapper<Product> productRowMapper() {
        return(rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getLong("id"));
            product.setCategory_id(rs.getLong("category_id"));
            product.setDescription(rs.getString("description"));
            product.setContent(rs.getString("content"));
            product.setEvent(rs.getString("event"));
            product.setCreate_date(rs.getDate("create_date"));
            product.setModify_date(rs.getDate("modify_date"));
            return product;
        };
    }
}
