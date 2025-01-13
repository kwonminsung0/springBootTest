package com.kh.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.domain.Board;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

	@PutMapping(value = "/{boardno}")
	public ResponseEntity<String> modify(@PathVariable("boardno") int boardno, @RequestBody Board board, Model model) {
		log.info("put boardno = " + boardno);
		log.info("put board = " + board.toString());

		ResponseEntity<String> entity = new ResponseEntity<String>("success", HttpStatus.OK);
		return entity;
	}

	@PostMapping(value = "/{boardno}")
	public ResponseEntity<String> modifyPost(@PathVariable("boardno") int boardno, @RequestBody Board board) {
		log.info("post boardno = " + boardno);
		log.info("post board = " + board.toString());

		ResponseEntity<String> entity = new ResponseEntity<String>("success", HttpStatus.OK);
		return entity;
	}

	@GetMapping(value = "/{boardno}", produces = "application/json")
	public ResponseEntity<Board> boardGetOne(@PathVariable("boardno") int boardno) {
		log.info("post boardno = " + boardno);
		Board board = new Board();

		board.setTitle("제목");
		board.setContent("내용입니다.");
		board.setWriter("홍길동");
		board.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}

	@GetMapping(value = "/get", params = "register")
	public String registerForm() {
		log.info("GET방식 등록");
		return "/board/register";
	}

	@PostMapping(value = "/post", params = "register")
	public String register() {
		log.info("POST방식 등록");
		return "/board/list";
	}

	@GetMapping(value = "/get", params = "modify")
	public String modifyForm() {
		log.info("GET방식 수정");
		return "/board/modify";
	}

	@PostMapping(value = "/post", params = "modify")
	public String modify() {
		log.info("POST방식 수정");
		return "/board/list";
	}

	@GetMapping(value = "/get", params = "remove")
	public String removeForm() {
		log.info("GET방식 삭제");
		return "/board/remove";
	}

	@PostMapping(value = "/post", params = "remove")
	public String remove() {
		log.info("POST방식 목록");
		return "/board/list";
	}

	@GetMapping(value = "/get", params = "list")
	public String list() {
		log.info("GET방식 목록");
		return "/board/list";
	}

	@GetMapping(value = "/get", params = "read")
	public String read() {
		log.info("GET방식 읽기");
		return "/board/read";
	}

}
