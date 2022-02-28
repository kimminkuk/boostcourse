package boostcourse1.boostcourse1spring.courseV3_v2.domain.product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();

    List<Product> findExhibitionAll();
    List<Product> findMusicalAll();
    List<Product> findConcertAll();
    List<Product> findClassicAll();
    List<Product> findTheaterAll();
}
