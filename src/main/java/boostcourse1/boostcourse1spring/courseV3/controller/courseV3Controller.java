package boostcourse1.boostcourse1spring.courseV3.controller;

import boostcourse1.boostcourse1spring.courseV3.domain.guestbook.Guestbook;
import boostcourse1.boostcourse1spring.courseV3.domain.guestbook.GuestbookService;
import boostcourse1.boostcourse1spring.courseV3.domain.log.Log;
import boostcourse1.boostcourse1spring.courseV3.domain.log.LogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/basic-v3/guestbook")
@RequiredArgsConstructor
public class courseV3Controller {
    private final GuestbookService guestbookService;
    private final LogService logService;

    @GetMapping("/list")
    public String guestList(Model model,
                            @RequestParam(name = "start", required = false, defaultValue = "0") int start) {
        int limit = 5;
        List<Guestbook> guestbooksALl = guestbookService.findGuestbooks();
        List<Guestbook> guestbooks = this.guestbookService.findGuestbookServicePage(start, limit);
        int count = guestbooksALl.size();
        int pageCount = count / limit;
        if ( count % limit > 0) {
            pageCount++;
        }

        List<Integer> pageStartList = new ArrayList<>();
        for(int i = 0; i < pageCount; i++) {
            pageStartList.add(i * limit);
        }

        model.addAttribute("guestbooks", guestbooks);
        model.addAttribute("guestSize", count);
        model.addAttribute("pageStartList", pageStartList);

        return "basic-v3/guestbook/list";
    }

    @PostMapping("/write")
    public void GuestbookAdd(Model model,
                             @RequestParam("name") String name,
                             @RequestParam("content") String content) {
        Date date = new Date();
        Guestbook savedGuestbook = new Guestbook(name, content, date);
        guestbookService.saveGuestbookService(savedGuestbook);

        //Log
        Log savedLog = new Log("127.0.0.1", "insert", date);
        logService.saveLogService(savedLog);

        return;
    }
}
