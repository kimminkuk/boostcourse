package boostcourse1.boostcourse1spring.courseV3_v2.repository;

import boostcourse1.boostcourse1spring.courseV3_v2.domain.file_info.File_info;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.file_info.File_infoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class JT_File_infoRepository implements File_infoRepository {
    private JdbcTemplate jdbcTemplate;

    public JT_File_infoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<File_info> findAll() {
        return jdbcTemplate.query("select * from file_info", file_infoRowMapper());
    }

    private RowMapper<File_info> file_infoRowMapper() {
        return(rs, rowNum) -> {
            File_info file_info = new File_info();
            file_info.setId(rs.getLong("id"));
            file_info.setFile_name(rs.getString("file_name"));
            file_info.setSave_file_name(rs.getString("save_file_name"));
            file_info.setContent_type(rs.getString("content_type"));
            file_info.setDelete_flag(rs.getInt("delete_flag"));
            file_info.setCreate_date(rs.getDate("create_date"));
            file_info.setModify_date(rs.getDate("modify_date"));
            return file_info;
        };
    }
}
