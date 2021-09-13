package co.altir.marketplace.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.altir.marketplace.entity.Retailer;

@Repository
public interface RetailerRepository extends CrudRepository<Retailer, Long> {
}
