package boostcourse1.boostcourse1spring.courseV3.domain.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class GuestbookService {
    private final GuestbookRepository guestbookRepository;

    @Autowired

    public GuestbookService(GuestbookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }

    public Guestbook saveGuestbookService(Guestbook guestbook) {
        return guestbookRepository.save(guestbook);
    }

    public List<Guestbook> findGuestbooks() {
        return guestbookRepository.findAll();
    }
}
