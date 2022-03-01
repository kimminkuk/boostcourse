package boostcourse1.boostcourse1spring.courseV3_v2.controller;

import boostcourse1.boostcourse1spring.courseV3_v2.domain.category.Category;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.category.CategoryService;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.product.Product;
import boostcourse1.boostcourse1spring.courseV3_v2.domain.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/basic-v3_v2")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class courseV3_v2Controller {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping("/HOME")
    public String categoryList(Model model) {
        List<Product> productsAll = productService.findProducts();
        int productAllSize = productsAll.size();

        List<Product> exhibitionProducts = productService.findExhibitionProducts();
        int exhibitionSize = exhibitionProducts.size();

        List<Product> musicalProducts = productService.findMusicalProducts();
        int musicalSize = musicalProducts.size();

        List<Product> concertProducts = productService.findConcertProducts();
        int concertSize = concertProducts.size();

        List<Product> classicsProducts = productService.findClassicsProducts();
        int classicSize = classicsProducts.size();

        List<Product> theaterProducts = productService.findTheaterProducts();
        int theaterSize = theaterProducts.size();

        model.addAttribute("productAll", productAllSize);
        model.addAttribute("product_Exhibition", exhibitionSize);
        model.addAttribute("product_Musical", musicalSize);
        model.addAttribute("product_Concert", concertSize);
        model.addAttribute("product_Classic", classicSize);
        model.addAttribute("product_Theater", theaterSize);
        return "basic-v3_v2/HOME";
    }
    @GetMapping("/HOME/{categoryId}")
    public String categorySort(@PathVariable int categoryId, Model model) {
        List<Product> store = null;
        switch (categoryId) {
            case 1:
                store = productService.findExhibitionProducts();
                break;
            default:
                break;
        }
        model.addAttribute("exhibition", store);
        return "basic-v3_v2/HOME";
    }
}
