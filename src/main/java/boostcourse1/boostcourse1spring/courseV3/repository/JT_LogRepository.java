package boostcourse1.boostcourse1spring.courseV3.repository;

import boostcourse1.boostcourse1spring.courseV3.domain.log.Log;
import boostcourse1.boostcourse1spring.courseV3.domain.log.LogRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JT_LogRepository implements LogRepository {
    private final JdbcTemplate jdbcTemplate;

    public JT_LogRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Log save(Log log) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("log").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ip", log.getIp());
        parameters.put("method", log.getMethod());
        parameters.put("regdate", log.getRegDate());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        log.setId(key.longValue());
        return log;
    }

    @Override
    public List<Log> findAll() {
        return jdbcTemplate.query("select * from log", logRowMapper());
    }

    private RowMapper<Log> logRowMapper() {
        return (rs, rowNum) -> {
            Log log = new Log();
            log.setId(rs.getLong("id"));
            log.setIp(rs.getString("ip"));
            log.setMethod(rs.getString("method"));
            log.setRegDate(rs.getDate("regdate"));
            return log;
        };
    }
}
