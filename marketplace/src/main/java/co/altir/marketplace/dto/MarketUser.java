package co.altir.marketplace.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MarketUser {

	private String username;
	private String password;
	private String name;
	private String address;
	private String email;
	private String role;
	private String productType;
}
