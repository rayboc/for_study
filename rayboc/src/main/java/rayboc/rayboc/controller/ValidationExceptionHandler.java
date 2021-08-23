//package rayboc.rayboc.controller;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//@ControllerAdvice
//public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
//
//	@Override
//	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object object, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		System.out.println(ex.getMessage());
//		return super.handleExceptionInternal(ex, "エラーだよ。", headers, status, request);
//	}
//
//}
