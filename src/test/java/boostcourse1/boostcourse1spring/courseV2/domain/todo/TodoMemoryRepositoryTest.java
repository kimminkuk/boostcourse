package boostcourse1.boostcourse1spring.courseV2.domain.todo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class TodoMemoryRepositoryTest {
    TodoMemoryRepository todoMemoryRepository  = new TodoMemoryRepository();

    @AfterEach
    void afterEach() {
        todoMemoryRepository.clearStore();
    }

    @Test
    void save() {
        //given
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = new Date();
        Todo todo1 = new Todo("프로젝트2 만들기", "요다입니다.", 1, "1순위", date);

        //when
        Todo savedTodo = todoMemoryRepository.save(todo1);

        //then
        assertThat(savedTodo.getId()).isEqualTo(2L);
    }

    @Test
    void findAll() {
        //given
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = new Date();
        Todo todo1 = new Todo("프로젝트2 만들기", "요다입니다.", 1, "1순위", date);

        //when
        Todo savedTodo = todoMemoryRepository.save(todo1);
        List<Todo> all = todoMemoryRepository.findAll();
    }
}