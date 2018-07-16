package com.globallogic.bookstore.model;

import lombok.Data;

@Data
public class BookDTO {
	private Long id;
	private String name;
	private int price;
	private int timesBought;
}
