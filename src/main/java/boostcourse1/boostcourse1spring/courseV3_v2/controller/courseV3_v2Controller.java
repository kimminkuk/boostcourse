package boostcourse1.boostcourse1spring.courseV3_v2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/basic-v3_v2")
@RequiredArgsConstructor
public class courseV3_v2Controller {

    @GetMapping("/HOME")
    public String testHome() {
        return "basic-v3_v2/HOME";
    }
}
