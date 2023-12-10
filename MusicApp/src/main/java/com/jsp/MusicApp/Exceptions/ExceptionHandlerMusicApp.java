package com.jsp.MusicApp.Exceptions;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.MusicApp.Util.ResponseStructure;



@RestControllerAdvice
public class ExceptionHandlerMusicApp {
	@ExceptionHandler(BodyMissingRequirdParameters.class)
public ResponseEntity<ResponseStructure<String>>bodyMissingRequirdParameters(BodyMissingRequirdParameters e){
		
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(e.getMessage());
		structure.setMessage("You cant perform this operation");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ArtistNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>>artistNotFoundException(ArtistNotFoundException a){
			
			ResponseStructure<String> structure=new ResponseStructure<String>();
			structure.setData(a.getMessage());
			structure.setMessage("Artist is Not present");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.FOUND);
		}
	

}
