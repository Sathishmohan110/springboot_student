package tcs.project.studentDetails.ExceptionHandler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ResponseApi.ResponseApi;
import customException.SdetailsValidationException;
import customException.UsernameAvailableException;
@RestControllerAdvice
public class exception {

	ResponseApi response=new ResponseApi();
	@ExceptionHandler
	public String handler(ArithmeticException e) {
		
		return "error has happened";
		
	}
	@ExceptionHandler
	public ResponseEntity<String> usernameException(UsernameAvailableException e) {
		
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(e.getMessage());

}
	@ExceptionHandler
	public ResponseEntity<ResponseApi> sdetailerror(SdetailsValidationException e ) {
		
		response.setError(e.getError());
		response.setData("Please eneter the valid input json");
		response.setStatus(HttpStatus.CONFLICT.value());
	return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		
	}
	}
