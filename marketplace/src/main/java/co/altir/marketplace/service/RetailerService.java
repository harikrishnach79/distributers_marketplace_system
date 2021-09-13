package co.altir.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.altir.marketplace.entity.Retailer;
import co.altir.marketplace.repository.RetailerRepository;

@Service
public class RetailerService {

    private final RetailerRepository retailerRepository;

    @Autowired
    public RetailerService(RetailerRepository retailerRepository) {
        this.retailerRepository = retailerRepository;
    }

    public String createRetailer(Retailer retailer) {
        retailerRepository.save(retailer);
        return "Retailer created successfully..";
    }


}
