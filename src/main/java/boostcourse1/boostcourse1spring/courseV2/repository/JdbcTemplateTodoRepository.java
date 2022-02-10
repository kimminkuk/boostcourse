package boostcourse1.boostcourse1spring.courseV2.repository;

import boostcourse1.boostcourse1spring.courseV2.domain.todo.Todo;
import boostcourse1.boostcourse1spring.courseV2.domain.todo.TodoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateTodoRepository implements TodoRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTodoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Todo> findById(Long todoId) {
        List<Todo> result = jdbcTemplate.query("select * from todo where id = ?", todoRowMapper(), todoId);
        return result.stream().findAny();
    }

    @Override
    public void update(Long todoId, Todo updateParam) {
        jdbcTemplate.update("update todo set sequence = ?, type = ? where id = ?",
                updateParam.getSequence(), updateParam.getType(), updateParam.getId());
    }

    @Override
    public Todo save(Todo todo) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("todo").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", todo.getTitle());
        parameters.put("name", todo.getName());
        parameters.put("sequence", todo.getSequence());
        parameters.put("type", todo.getType());
        parameters.put("regdate", todo.getRegDate());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        todo.setId(key.longValue());
        return todo;
    }

    @Override
    public List<Todo> findAll() {
        return jdbcTemplate.query("select * from todo", todoRowMapper());
    }

    @Override
    public Optional<Todo> findByTitle(String title) {
        List<Todo> result = jdbcTemplate.query("select * from todo where title = ?", todoRowMapper(), title);
        return result.stream().findAny();
    }

    private RowMapper<Todo> todoRowMapper() {
        return (rs, rowNum) -> {
            Todo todo = new Todo();
            todo.setId(rs.getLong("id"));
            todo.setTitle(rs.getString("title"));
            todo.setName(rs.getString("name"));
            todo.setSequence(rs.getInt("sequence"));
            todo.setType(rs.getString("type"));
            todo.setRegDate(rs.getDate("regdate"));
            return todo;
        };
    }
}
