package boostcourse1.boostcourse1spring.courseV3_v2.controller;

import boostcourse1.boostcourse1spring.courseV3_v2.domain.category.Category;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.category.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/basic-v3_v2")
@RequiredArgsConstructor
public class courseV3_v2Controller {
    private final CategoryService categoryService;

    @GetMapping("/HOME")
    public String categoryList(Model model) {
        List<Category> categoryAll = categoryService.findCategorys();
        int categoryLength = categoryAll.size();

        model.addAttribute("categorySize", categoryLength);
        return "basic-v3_v2/HOME";
    }
}
