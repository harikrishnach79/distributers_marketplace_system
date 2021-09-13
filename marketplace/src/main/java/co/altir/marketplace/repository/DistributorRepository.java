package co.altir.marketplace.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.altir.marketplace.entity.Distributor;

@Repository
public interface DistributorRepository extends CrudRepository<Distributor, Long> {

}
