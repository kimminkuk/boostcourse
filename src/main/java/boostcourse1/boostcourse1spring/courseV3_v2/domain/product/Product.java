package boostcourse1.boostcourse1spring.courseV3_v2.domain.product;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private Long id;
    private Long category_id;
    private String description;
    private String content;
    private String event;
    private Date create_date;
    private Date modify_date;

    public Product() {
    }

    public Product(Long category_id, String description, String content, String event, Date create_date, Date modify_date) {
        this.category_id = category_id;
        this.description = description;
        this.content = content;
        this.event = event;
        this.create_date = create_date;
        this.modify_date = modify_date;
    }
}
