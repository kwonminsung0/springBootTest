package com.project.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Notice {
	private int noticeNo;
	private String title;
	private String content;
	private Date regDate;
}
