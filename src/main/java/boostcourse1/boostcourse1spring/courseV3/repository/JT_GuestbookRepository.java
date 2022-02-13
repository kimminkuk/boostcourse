package boostcourse1.boostcourse1spring.courseV3.repository;

import boostcourse1.boostcourse1spring.courseV3.domain.guestbook.Guestbook;
import boostcourse1.boostcourse1spring.courseV3.domain.guestbook.GuestbookRepository;
import boostcourse1.boostcourse1spring.courseV3.domain.log.Log;
import boostcourse1.boostcourse1spring.courseV3.domain.log.LogRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JT_GuestbookRepository implements GuestbookRepository {
    private final JdbcTemplate jdbcTemplate;

    public JT_GuestbookRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Guestbook save(Guestbook guestbook) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("guestbook").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", guestbook.getName());
        parameters.put("content", guestbook.getContent());
        parameters.put("regdate", guestbook.getRegDate());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        guestbook.setId(key.longValue());
        return guestbook;
    }

    @Override
    public List<Guestbook> findAll() {
        return jdbcTemplate.query("select * from guestbook", guestbookRowMapper());
    }

    //피드백 필요함.(내용 분석)
    //RowMapper
    @Override
    public List<Guestbook> findPageList(int start, int limit) {
        return jdbcTemplate.query("select * from guestbook order by id desc limit ?, ?", guestbookRowMapper(), start, limit);
    }

    private RowMapper<Guestbook> guestbookRowMapper() {
        return (rs, rowNum) -> {
            Guestbook guestbook = new Guestbook();
            guestbook.setId(rs.getLong("id"));
            guestbook.setName(rs.getString("name"));
            guestbook.setContent(rs.getString("content"));
            guestbook.setRegDate(rs.getDate("regdate"));
            return guestbook;
        };
    }
}
