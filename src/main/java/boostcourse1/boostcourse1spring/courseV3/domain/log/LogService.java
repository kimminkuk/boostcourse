package boostcourse1.boostcourse1spring.courseV3.domain.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Log saveLogService(Log log) {
        return logRepository.save(log);
    }

    public List<Log> findLogs() {
        return logRepository.findAll();
    }
}
