package com.zeus.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.backend.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MemoController {
	@Autowired
	private MemoService service;

	@GetMapping("/memo")
	public List<Map<String, Object>> list(@RequestParam(name = "memo", defaultValue = "") String memo)
			throws Exception {
		System.out.println("list...");
		return service.list(memo);
	}

	@PostMapping("/memo/insert")
	public void insert(@RequestParam Map<String, Object> map) throws Exception {
		System.out.println("map:" + map);
		service.insert(map);
	}

	@RequestMapping("/memo/detail/{idx}")
	public Map<String, Object> detail(@PathVariable(name = "idx") int idx) throws Exception {
		log.info("memo detail idx=" + idx);
		return service.detail(idx);
	}

	@RequestMapping("/memo/update")
	public void update(@RequestParam Map<String, Object> map) throws Exception {
		service.update(map);
	}

	@RequestMapping("/memo/delete")
	public void delete(@RequestParam(name = "idx") int idx) throws Exception {
		service.delete(idx);
	}

}
