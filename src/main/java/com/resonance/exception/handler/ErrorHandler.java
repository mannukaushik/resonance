package com.resonance.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.resonance.api.elements.ApplicationException;
import com.resonance.api.elements.DataNotFoundException;
import com.resonance.api.elements.DuplicateDataException;
import com.resonance.api.elements.InvalidDataException;
import com.resonance.api.elements.ResponseMessageModel;

@Transactional(rollbackFor = Exception.class)
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
		String message = ex.getMessage();
		if(null == message) {
			if(ex instanceof NullPointerException) {
				message = "Null Pointer Exception occured";
			}else {
				message = ex.getCause().toString();
			}
		}
		return new ResponseEntity<>(handleErrors(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({DataNotFoundException.class})
	public ResponseEntity<?> handleDataNotFoundException(DataNotFoundException ex){
		return new ResponseEntity<>(handleErrors(ex), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler({DuplicateDataException.class})
	public ResponseEntity<?> handleDuplicateDataException(DuplicateDataException ex){
		return new ResponseEntity<>(handleErrors(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler({InvalidDataException.class})
	public ResponseEntity<?> handleInvalidDataException(InvalidDataException ex){
		return new ResponseEntity<>(handleErrors(ex), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler({ApplicationException.class})
	public ResponseEntity<?> handleApplicationException(ApplicationException ex){
		return new ResponseEntity<>(handleErrors(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	private Map<String, Object> handleErrors(RuntimeException ex){

		ResponseMessageModel messageModel = new ResponseMessageModel();
		Map<String, Object> errorMap = new HashMap<String, Object>();
		messageModel.setMessage(ex.getMessage());
		messageModel.setOutcome("Failure");
		errorMap.putIfAbsent("messages", messageModel);
		return errorMap;
	}

}
