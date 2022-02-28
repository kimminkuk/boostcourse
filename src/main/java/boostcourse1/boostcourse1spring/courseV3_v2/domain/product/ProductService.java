package boostcourse1.boostcourse1spring.courseV3_v2.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public List<Product> findExhibitionProducts() {
        return productRepository.findExhibitionAll();
    }

    public List<Product> findMusicalProducts() {
        return productRepository.findMusicalAll();
    }

    public List<Product> findTheaterProducts() {
        return productRepository.findTheaterAll();
    }

    public List<Product> findClassicsProducts() {
        return productRepository.findClassicAll();
    }

    public List<Product> findConcertProducts() {
        return productRepository.findConcertAll();
    }
}
