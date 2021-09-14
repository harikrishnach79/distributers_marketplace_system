package co.altir.marketplace.exception;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomErrorResponse implements Serializable {

	private static final long serialVersionUID = -3259092915747250946L;
	private Date timestamp;
	private HttpStatus status;
	private String errMsg;
	private String path;
}
