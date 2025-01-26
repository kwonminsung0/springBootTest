package com.project.common.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.project.exception.NotEnoughCoinException;
import com.project.exception.NotMyItemException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

	// 코인 부족 예외 처리
	// @ExceptionHandler 메서드를 사용하여 여러 컨트롤러에서 발생할 수 있는 예외들을 중앙에서 처리한다.
	@ExceptionHandler(NotEnoughCoinException.class)
	public String handleNotEnoughCoinException(NotEnoughCoinException ex, WebRequest request) {
		log.info("handleNotEnoughCoinException");
		return "redirect:/coin/notEnoughCoin";
	}

	// 본인 상품 예외 처리
	@ExceptionHandler(NotMyItemException.class)
	public String handleNotMyItemException(NotMyItemException ex, WebRequest request) {
		log.info("handleNotMyItemException");
		return "redirect:/useritem/notMyItem";
	}

	// 접근 거부 예외 처리
	@ExceptionHandler(AccessDeniedException.class)
	public void handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (isAjax(request)) {
			// 401 상태코드, 클라이언트가 인증되지 않았거나 권한이 없는곳을 접근하고 있음을 표시함.
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		} else {
			throw ex;
		}
	}

	// 일반 예외 처리
	@ExceptionHandler(Exception.class)
	public String handle(Exception ex) {
		log.info("handle ex " + ex.toString());
		return "error/errorCommon";
	}

	public static boolean isAjax(HttpServletRequest request) {
		// 클라이언트가 AJAX 요청으로 해당 요청을 보냈는지를 확인함 아니면, 일반적인 폼 submit 등의 요청인 경우
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}
}
