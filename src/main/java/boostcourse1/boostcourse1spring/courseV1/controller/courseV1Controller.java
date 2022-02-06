package boostcourse1.boostcourse1spring.courseV1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/basic")
public class courseV1Controller {

    @GetMapping("/today")
    public String timeTest(Model model) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int year = localDateTime.getYear();
        int monthValue = localDateTime.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        String result = Integer.toString(year) +"/"+ Integer.toString(monthValue) + "/" +
                Integer.toString(dayOfMonth) + " " + Integer.toString(hour) + ":" + Integer.toString(minute);
        model.addAttribute("data",result);
        return "basic/today";
    }

    @GetMapping("/project-1")
    public String testProject1() {
        return "basic/project_1";
    }

    @GetMapping("/project-2")
    public String testProject2() {
        return "basic/project_2";
    }

    @GetMapping("/project-3")
    public String testProject3() {
        return "basic/project_3";
    }
}
