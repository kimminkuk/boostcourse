package boostcourse1.boostcourse1spring.courseV3.domain.log;

import lombok.Data;

import java.util.Date;

@Data
public class Log {
    private Long id;
    private String ip;
    private String method;
    private Date regDate;

    public Log() {
    }

    public Log(String ip, String method, Date regDate) {
        this.ip = ip;
        this.method = method;
        this.regDate = regDate;
    }
}
