package boostcourse1.boostcourse1spring.courseV3_v2.domain.file_info;

import lombok.Data;

import java.util.Date;

@Data
public class File_info {
    private long id;
    private String file_name;
    private String save_file_name;
    private String content_type;
    private int delete_flag;
    private Date create_date;
    private Date modify_date;

    public File_info() {
    }

    public File_info(String file_name, String save_file_name, String content_type, int delete_flag, Date create_date, Date modify_date) {
        this.file_name = file_name;
        this.save_file_name = save_file_name;
        this.content_type = content_type;
        this.delete_flag = delete_flag;
        this.create_date = create_date;
        this.modify_date = modify_date;
    }
}
