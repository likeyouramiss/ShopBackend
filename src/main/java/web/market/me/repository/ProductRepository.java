package web.market.me.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.market.me.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
