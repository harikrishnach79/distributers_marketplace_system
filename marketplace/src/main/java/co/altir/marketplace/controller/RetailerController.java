package co.altir.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.altir.marketplace.service.RetailerService;

@RestController
@RequestMapping("/v1/retailer/")
public class RetailerController {

	private final RetailerService retailerService;

	@Autowired
	public RetailerController(RetailerService retailerService) {
		this.retailerService = retailerService;
	}

	@GetMapping("/test")
	public String test() {
		return "Success";
	}

}
