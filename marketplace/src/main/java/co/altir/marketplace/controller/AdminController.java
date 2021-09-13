package co.altir.marketplace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.altir.marketplace.dto.MarketUser;
import co.altir.marketplace.service.AdminService;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

	private final AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@GetMapping("/test")
	public String test() {
		return "Success";
	}

	@PostMapping("/user")
	public ResponseEntity<String> createMarketUser(@RequestBody MarketUser marketUser) {
		adminService.createUser(marketUser);
		return ResponseEntity.ok().body("Registration success");
	}
}
