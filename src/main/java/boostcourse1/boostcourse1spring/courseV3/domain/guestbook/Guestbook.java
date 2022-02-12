package boostcourse1.boostcourse1spring.courseV3.domain.guestbook;

import lombok.Data;

import java.util.Date;

@Data
public class Guestbook {
    private Long id;
    private String name;
    private String content;
    private Date regDate;

    public Guestbook() {
    }

    public Guestbook(String name, String content, Date regDate) {
        this.name = name;
        this.content = content;
        this.regDate = regDate;
    }
}
