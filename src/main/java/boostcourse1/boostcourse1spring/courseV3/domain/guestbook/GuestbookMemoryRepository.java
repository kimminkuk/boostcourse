package boostcourse1.boostcourse1spring.courseV3.domain.guestbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuestbookMemoryRepository implements GuestbookRepository {
    private static final Map<Long, Guestbook> store = new HashMap<>();
    private static long sequence = 0L;
    private static int limit = 5;
    @Override
    public Guestbook save(Guestbook guestbook) {
        guestbook.setId(++sequence);
        store.put(guestbook.getId(), guestbook);
        return guestbook;
    }

    @Override
    public List<Guestbook> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Guestbook> findPageList(int start, int limit) {
        return null;
    }

    public void clearStore() {
        store.clear();
    }
}
