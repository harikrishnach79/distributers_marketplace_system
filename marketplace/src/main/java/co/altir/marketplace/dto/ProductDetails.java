package co.altir.marketplace.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDetails {
	private String name;
	private String description;
	private Double price;
	private Long distributorId;
}
