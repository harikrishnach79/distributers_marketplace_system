package co.altir.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.altir.marketplace.dto.OfferDetails;
import co.altir.marketplace.dto.ProductDetails;
import co.altir.marketplace.models.ProductInfo;
import co.altir.marketplace.service.DistributerService;

@RestController
@RequestMapping("/v1/distributer")
public class DistributerController {

	private final DistributerService distributerService;

	@Autowired
	public DistributerController(DistributerService distributerService) {
		this.distributerService = distributerService;
	}

	@GetMapping("/test")
	public String test() {
		return "Success";
	}

	@PostMapping("/product/offer")
	public ResponseEntity<String> createOffer(@RequestBody OfferDetails offerDetails) {
		return ResponseEntity.ok().body(distributerService.createOffer(offerDetails));
	}

	@PostMapping("/product")
	public ResponseEntity<String> createProduct(@RequestBody ProductDetails productDetails) {
		return ResponseEntity.ok().body(distributerService.createProduct(productDetails));
	}

	@GetMapping("/product/{distrId}")
	public List<ProductInfo> getProducts(@PathVariable("distrId") Long distrId) {
		return distributerService.getProductsByDistributorId(distrId);
	}

}
