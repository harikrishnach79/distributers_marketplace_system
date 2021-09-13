package co.altir.marketplace.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductInfo {
	private Integer productId;
	private String name;
	private String description;
	private Double price;
	private Long distributorId;
	private List<OfferInfo> offers;
}
