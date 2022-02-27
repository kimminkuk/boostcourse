package boostcourse1.boostcourse1spring.courseV3_v2.domain.category;

import lombok.Data;

@Data
public class Category {
    private Long id;
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
}
