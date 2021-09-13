package co.altir.marketplace.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.altir.marketplace.entity.Offer;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Integer> {

}
