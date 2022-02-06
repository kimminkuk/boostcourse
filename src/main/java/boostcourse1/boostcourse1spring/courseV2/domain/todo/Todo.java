package boostcourse1.boostcourse1spring.courseV2.domain.todo;

import lombok.Data;

import java.util.Date;

@Data
public class Todo {
    private Long id;
    private String title;
    private String name;
    private int sequence;
    private String type;
    private Date regDate;

    public Todo() {
    }

    public Todo(String title, String name, int sequence, String type, Date regDate) {
        this.title = title;
        this.name = name;
        this.sequence = sequence;
        this.type = type;
        this.regDate = regDate;
    }
}


