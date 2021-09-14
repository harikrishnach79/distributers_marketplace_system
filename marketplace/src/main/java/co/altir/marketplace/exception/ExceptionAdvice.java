package co.altir.marketplace.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler({ MarketplaceException.class })
	public ResponseEntity<CustomErrorResponse> handleInternalServerError(MarketplaceException ex,
			final HttpServletRequest request) {
		CustomErrorResponse errorResponse = new CustomErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR,
				ex.getMessage(), request.getRequestURI());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
