package com.zeus.backend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.backend.service.GuestbookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class GuestbookController {
	@Autowired
	private GuestbookService service;

	@RequestMapping("/guestbook")
	public List<Map<String, Object>> list(@RequestParam(name = "searchkey", defaultValue = "name") String searchkey,
			@RequestParam(name = "search", defaultValue = "") String search) throws Exception {
		System.out.println("searchkey:" + searchkey);
		System.out.println("search:" + search);
		List<Map<String, Object>> listMap = service.list(searchkey, search);
		log.info("listMap" + listMap.toString());
		return listMap;
	}

	@RequestMapping("/guestbook/insert")
	public void insert(@RequestParam Map<String, Object> map) throws Exception {
		service.insert(map);
	}

	@RequestMapping("/guestbook/detail/{idx}")
	public Map<String, Object> detail(@PathVariable(name = "idx") int idx) throws Exception {
		return service.detail(idx);
	}

	@RequestMapping("/guestbook/update")
	public Map<String, Object> update(@RequestParam Map<String, Object> map) throws Exception {
		Map<String, Object> result_map = new HashMap<>();
		// hash map으로 받을 경우 자료형이 고정되지 않는 단점이 있음. 스트링 => 정수로 두번 변환
		log.info("map" + map.toString());
		int idx = Integer.parseInt(String.valueOf(map.get("idx")));
		String passwd = String.valueOf(map.get("passwd"));
		if (service.check_pwd(idx, passwd)) {
			service.update(map);
			result_map.put("result", "success");
		} else {
			result_map.put("result", "fail");
		}
		return result_map;
	}

	@RequestMapping("/guestbook/delete")
	public Map<String, Object> delete(@RequestParam(name = "idx") int idx, @RequestParam(name = "passwd") String passwd)
			throws Exception {
		Map<String, Object> result_map = new HashMap<>();
		if (service.check_pwd(idx, passwd)) {
			service.delete(idx);
			result_map.put("result", "success");
		} else {
			result_map.put("result", "fail");
		}
		return result_map;
	}
}
