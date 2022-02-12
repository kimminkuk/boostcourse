package boostcourse1.boostcourse1spring.courseV3.domain.log;

import java.util.List;

public interface LogRepository {
    Log save(Log log);

    List<Log> findAll();

}
