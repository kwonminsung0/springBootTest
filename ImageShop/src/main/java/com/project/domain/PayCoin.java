package com.project.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PayCoin {
	private int historyNo;
	private int userNo;
	private int itemId;
	private String itemName;
	private int amount;
	private Date regDate;
}
