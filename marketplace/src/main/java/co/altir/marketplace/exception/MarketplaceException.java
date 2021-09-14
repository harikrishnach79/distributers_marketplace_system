package co.altir.marketplace.exception;

public class MarketplaceException extends RuntimeException {

	private static final long serialVersionUID = -3259090915747250946L;

	public MarketplaceException(String message) {
		super(message);
	}

	public MarketplaceException(String message, Throwable cause) {
		super(message, cause);
	}
}
