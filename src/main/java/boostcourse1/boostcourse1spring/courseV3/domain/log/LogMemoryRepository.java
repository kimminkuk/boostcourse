package boostcourse1.boostcourse1spring.courseV3.domain.log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogMemoryRepository implements LogRepository {
    private static final Map<Long, Log> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Log save(Log log) {
        log.setId(++sequence);
        store.put(log.getId(), log);
        return log;
    }

    @Override
    public List<Log> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
