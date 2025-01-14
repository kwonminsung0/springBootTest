package com.zeus.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home"; // 뷰 파일명
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		// 미리 정의된 메시지에 값을 넘겨준다.
		String[] args = { "이순신" };
		String[] args2 = { "Mr. Lee" };
		// 스프링 프레임워크로부터 MessageSource를 주입 받은 다음 getMessage 메서드를 호출한다.
		String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN);
		String message2 = messageSource.getMessage("welcome.message", args2, Locale.ENGLISH);
		log.info("Welcome message : " + message);
		log.info("Welcome message2 : " + message2);
		return "home"; // 뷰 파일명
	}

}