package co.altir.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.altir.marketplace.dto.MarketUser;
import co.altir.marketplace.entity.Distributor;
import co.altir.marketplace.entity.Retailer;
import co.altir.marketplace.entity.User;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminService {

	private final RetailerService retailerService;
	private final DistributerService distributerService;
	private final UserDetailsServiceImpl userDetailsService;

	@Autowired
	public AdminService(RetailerService retailerService, DistributerService distributerService,
			UserDetailsServiceImpl userDetailsService) {
		this.distributerService = distributerService;
		this.retailerService = retailerService;
		this.userDetailsService = userDetailsService;
	}

	public void createUser(MarketUser marketUser) {
		User user = new User();
		user.setUsername(marketUser.getUsername());
		user.setPassword(marketUser.getPassword());
		String role = marketUser.getRole();
		user.setRole(role);
		user.setEnabled(true);
		log.info("User : {}", user.toString());

		switch (role) {
		case "ROLE_DISTR":
			Distributor distributor = new Distributor();
			distributor.setName(marketUser.getName());
			distributor.setAddress(marketUser.getAddress());
			distributor.setEmail(marketUser.getEmail());
			distributor.setProductType(marketUser.getProductType());
			distributerService.createDistributer(distributor);
			break;
		case "ROLE_RTLR":
			Retailer retailer = new Retailer();
			retailer.setName(marketUser.getName());
			retailer.setAddress(marketUser.getAddress());
			retailer.setEmail(marketUser.getEmail());
			retailerService.createRetailer(retailer);
			break;
		default:
			throw new IllegalArgumentException("Invalid role...");
		}
		userDetailsService.createUser(user);
	}
}
