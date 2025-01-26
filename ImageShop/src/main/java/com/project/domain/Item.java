package com.project.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Item {
	private Integer itemId; 
	private String itemName; 
	private Integer price; 
	private String description; 
	private MultipartFile picture; 
	private String pictureUrl; 
	private MultipartFile preview; 
	private String previewUrl;
}
