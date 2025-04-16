package com.oee.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.oee.util.DateUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {
	
	 private Status status;
	    private T payload;
	    private Object errors;
	    private Object metadata;
	    private Object respData;

	    public static <T> Response<T> badRequest() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.BAD_REQUEST);
	        return response;
	    }

	    public static <T> Response<T> ok() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.OK);
	        return response;
	    }
	    public static <T> Response<T> created() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.CREATED);
	        return response;
	    }

	    public static <T> Response<T> unauthorized() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.UNAUTHORIZED);
	        return response;
	    }

	    public static <T> Response<T> validationException() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.VALIDATION_EXCEPTION);
	        return response;
	    }

	    public static <T> Response<T> wrongCredentials() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.WRONG_CREDENTIALS);
	        return response;
	    }

	    public static <T> Response<T> accessDenied() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.ACCESS_DENIED);
	        return response;
	    }

	    public static <T> Response<T> exception() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.EXCEPTION);
	        return response;
	    }

	    public static <T> Response<T> notFound() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.NOT_FOUND);
	        return response;
	    }

	    public static <T> Response<T> duplicateEntity() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.DUPLICATE_ENTITY);
	        return response;
	    }
	    
	    public static <T> Response<T> forbidden() {
	        Response<T> response = new Response<>();
	        response.setStatus(Status.FORBIDDEN_ENTITY);
	        return response;
	    }
	    
	    public void addErrorMsgToResponse(String errorMsg, Exception ex) {
	        ResponseError error = new ResponseError()
	                .setDetails(ex.getMessage())
	                .setMessage(errorMsg)
	                .setTimestamp(DateUtils.today());
	        setErrors(error);
	    }

		/*
		 * public void addErrorMsgToResponse(String errorMsg, Exception ex) { Response
		 * error = new Response() .setDetails(ex.getMessage()) .setMessage(errorMsg)
		 * .setTimestamp(DateUtils.today()); setErrors(error); }
		 */

	    public enum Status {
	        OK,CREATED, BAD_REQUEST, UNAUTHORIZED, VALIDATION_EXCEPTION, EXCEPTION, WRONG_CREDENTIALS, ACCESS_DENIED, NOT_FOUND, DUPLICATE_ENTITY ,FORBIDDEN_ENTITY
	    }

	    @Getter
	    @Accessors(chain = true)
	    @JsonInclude(JsonInclude.Include.NON_NULL)
	    @JsonIgnoreProperties(ignoreUnknown = true)
	    public static class PageMetadata {
	        private final int size;
	        private final long totalElements;
	        private final int totalPages;
	        private final int number;

	        public PageMetadata(int size, long totalElements, int totalPages, int number) {
	            this.size = size;
	            this.totalElements = totalElements;
	            this.totalPages = totalPages;
	            this.number = number;
	        }
	    }

	
	

}
