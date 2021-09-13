package co.altir.marketplace.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OfferDetails {
	private Double discount;
	private Integer productId;
	private String promotion;
}
