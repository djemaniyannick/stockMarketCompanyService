package com.codeimmig.yannick.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codeimmig.yannick.exception.CompanyNotFoundException;
import com.codeimmig.yannick.payload.response.ErrorMessage;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	public ResponseEntity<ErrorMessage> handleCompanyNotFoundException(CompanyNotFoundException cne){
		return ResponseEntity.internalServerError().body( new ErrorMessage(
				new Date().toString(),
				cne.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.name()
				));
		
	}

}
