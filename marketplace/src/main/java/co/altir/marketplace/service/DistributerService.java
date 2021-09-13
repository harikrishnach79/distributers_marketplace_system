package co.altir.marketplace.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.altir.marketplace.dto.OfferDetails;
import co.altir.marketplace.dto.ProductDetails;
import co.altir.marketplace.entity.Distributor;
import co.altir.marketplace.entity.Offer;
import co.altir.marketplace.entity.Product;
import co.altir.marketplace.models.OfferInfo;
import co.altir.marketplace.models.ProductInfo;
import co.altir.marketplace.repository.DistributorRepository;
import co.altir.marketplace.repository.OfferRepository;
import co.altir.marketplace.repository.ProductRepository;

@Service
public class DistributerService {

	private final DistributorRepository distributorRepository;
	private final ProductRepository productRepository;
	private final OfferRepository offerRepository;

	@Autowired
	public DistributerService(DistributorRepository distributorRepository, ProductRepository productRepository,
			OfferRepository offerRepository) {
		this.distributorRepository = distributorRepository;
		this.productRepository = productRepository;
		this.offerRepository = offerRepository;
	}

	public String createDistributer(Distributor distributor) {
		distributorRepository.save(distributor);
		return "Distributor created successfully..";
	}

	public String createOffer(OfferDetails offerDetails) {
		Offer offer = new Offer();
		offer.setDiscount(offerDetails.getDiscount());
		offer.setPromotion(offerDetails.getPromotion());
		Optional<Product> productdetails = productRepository.findById(offerDetails.getProductId());
		if (productdetails.isPresent()) {
			offer.setProduct(productdetails.get());
		} else {
			throw new IllegalArgumentException("Invalid product or product not found...");
		}
		offerRepository.save(offer);
		return "offer created successfully..";
	}

	public String createProduct(ProductDetails productDetails) {
		Product product = new Product();
		product.setName(productDetails.getName());
		product.setDescription(productDetails.getDescription());
		product.setPrice(productDetails.getPrice());
		Optional<Distributor> distributordetails = distributorRepository.findById(productDetails.getDistributorId());
		if (distributordetails.isPresent()) {
			product.setDistributor(distributordetails.get());
		} else {
			throw new IllegalArgumentException("Invalid distributor or distributor not found...");
		}
		product = productRepository.save(product);
		return "Product with productid: " + product.getId().toString() + " created sucessfully";
	}

	public List<ProductInfo> getProductsByDistributorId(Long distributorId) {
		List<Product> products = productRepository.findAllByDistributorId(distributorId);
		List<ProductInfo> productsList = new ArrayList<>();
		for (Product product : products) {
			ProductInfo productInfo = new ProductInfo();
			productInfo.setProductId(product.getId());
			productInfo.setDescription(product.getDescription());
			productInfo.setName(product.getName());
			productInfo.setPrice(product.getPrice());
			Distributor distributor = product.getDistributor();
			productInfo.setDistributorId(distributor.getId());
			List<Offer> offers = product.getOffer();
			List<OfferInfo> offersList = new ArrayList<>();
			for (Offer offer : offers) {
				OfferInfo offerInfo = new OfferInfo();
				offerInfo.setDiscount(offer.getDiscount());
				offerInfo.setId(offer.getId());
				offerInfo.setPromotion(offer.getPromotion());
				offersList.add(offerInfo);
			}
			productInfo.setOffers(offersList);
			productsList.add(productInfo);
		}
		return productsList;
	}

}
