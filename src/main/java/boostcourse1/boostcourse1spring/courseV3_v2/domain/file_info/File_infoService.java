package boostcourse1.boostcourse1spring.courseV3_v2.domain.file_info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class File_infoService {
    private final File_infoRepository file_infoRepository;

    @Autowired
    public File_infoService(File_infoRepository file_infoRepository) {
        this.file_infoRepository = file_infoRepository;
    }

    public List<File_info> findFile_infos() {
        return file_infoRepository.findAll();
    }
}
