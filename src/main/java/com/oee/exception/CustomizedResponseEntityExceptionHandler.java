package com.oee.exception;

import java.nio.file.AccessDeniedException;

import javax.naming.AuthenticationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oee.dto.response.Response;
import com.oee.exception.BRSException.ConstraintViolationException;



/**
 * Created by Keshav Patel.
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(CustomizedResponseEntityExceptionHandler.class);
	
    @ExceptionHandler(BRSException.EntityNotFoundException.class)
    public final ResponseEntity handleNotFountExceptions(Exception ex, WebRequest request) {
        Response response = Response.notFound();
        response.addErrorMsgToResponse(ex.getMessage(), ex);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BRSException.DuplicateEntityException.class)
    public final ResponseEntity handleNotFountExceptions1(Exception ex, WebRequest request) {
        Response response = Response.duplicateEntity();
        response.addErrorMsgToResponse(ex.getMessage(), ex);
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }
    
    @ExceptionHandler(ArithmeticException.class)
	public final ResponseEntity handaleArithmeticException(Exception ex, WebRequest request){
		
    	 Response response = Response.exception();
         response.addErrorMsgToResponse(ex.getMessage(), ex);
         logger.error(ex.getMessage(), ex);
         
         return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}
    
    @ExceptionHandler(BRSException.UnauthorizedEntityException.class)
   	public final ResponseEntity handaleUnauthorizedException(Exception ex, WebRequest request){
       	 Response response = Response.unauthorized();
            response.addErrorMsgToResponse(ex.getMessage(), ex);
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
   	}
    
    
    @ExceptionHandler(AuthenticationException.class)
	public final ResponseEntity handaleAuthenticationException(Exception ex, WebRequest request){
    	 Response response = Response.unauthorized();
         response.addErrorMsgToResponse(ex.getMessage(), ex);
         logger.error(ex.getMessage(), ex);
         
         return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
	}
    
	/*
	 * @ExceptionHandler(BadCredentialsException.class) public final ResponseEntity
	 * handaleBadCredentialsException(Exception ex, WebRequest request){ Response
	 * response = Response.unauthorized();
	 * response.addErrorMsgToResponse(ex.getMessage(), ex);
	 * logger.error(ex.getMessage(), ex);
	 * 
	 * return new ResponseEntity(response, HttpStatus.UNAUTHORIZED); }
	 */
    
    @ExceptionHandler(DataIntegrityViolationException.class)
   	public final ResponseEntity handaleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request){
   		
       	 Response response = Response.badRequest();
            response.addErrorMsgToResponse("Cannot delete row.", ex);
            logger.error(ex.getMessage(), ex);
            
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
   	}
    
    
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        
        Response response = Response.badRequest();
        response.addErrorMsgToResponse("Cannot delete row.", ex);
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    
    // 403
	/*
	 * @ExceptionHandler({ AccessDeniedException.class }) public
	 * ResponseEntity<Object> handleAccessDeniedException(final Exception ex, final
	 * WebRequest request) {
	 * 
	 * Response response = Response.forbidden();
	 * response.addErrorMsgToResponse(ex.getMessage(), ex);
	 * logger.error(ex.getMessage(), ex); return new ResponseEntity(response,
	 * HttpStatus.FORBIDDEN); }
	 */
    
    
    @ExceptionHandler(Exception.class)
	public final ResponseEntity handaleException(Exception ex, WebRequest request){
		
    	 Response response = Response.exception();
         response.addErrorMsgToResponse(ex.getMessage(), ex);
         logger.error(ex.getMessage(), ex);
         
         return new ResponseEntity(response, HttpStatus.BAD_GATEWAY);
	}
    
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//	public final ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request){
//		
//    	 Response response = Response.exception();
//         response.addErrorMsgToResponse(ex.getMessage(), ex);
//         logger.error(ex.getMessage(), ex);
//         
//         return new ResponseEntity(response, HttpStatus.BAD_GATEWAY);
//	}
    
    
    
}