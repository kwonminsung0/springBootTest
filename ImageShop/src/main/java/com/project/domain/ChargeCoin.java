package com.project.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ChargeCoin {
	private int historyNo; 
	private int userNo; 
	private int amount; 
	private Date regDate;
}
