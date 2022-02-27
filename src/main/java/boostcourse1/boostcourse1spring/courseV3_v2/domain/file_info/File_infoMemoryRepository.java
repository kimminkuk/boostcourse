package boostcourse1.boostcourse1spring.courseV3_v2.domain.file_info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class File_infoMemoryRepository implements  File_infoRepository{
    private static final Map<Long, File_info> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public List<File_info> findAll() {
        return new ArrayList<>(store.values());
    }
}
