package boostcourse1.boostcourse1spring.courseV3.domain.guestbook;

import java.util.List;

public interface GuestbookRepository {
    Guestbook save(Guestbook guestbook);
    List<Guestbook> findAll();
}
