package boostcourse1.boostcourse1spring.courseV3.controller;

import boostcourse1.boostcourse1spring.courseV3.domain.guestbook.GuestbookService;
import boostcourse1.boostcourse1spring.courseV3.domain.log.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic-v3")
@RequiredArgsConstructor
public class courseV3Controller {
    private final GuestbookService guestbookService;
    private final LogService logService;

    @GetMapping("/HOME")
    public String guestList(Model model) {
        return "basic-v3/HOME";
    }
}
