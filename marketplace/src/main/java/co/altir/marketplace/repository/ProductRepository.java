package co.altir.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.altir.marketplace.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("select p from Product p where p.distributor.id = :distributorId")
	List<Product> findAllByDistributorId(@Param(value = "distributorId") Long distributorId);
}
