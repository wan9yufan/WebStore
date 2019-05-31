package nju.yufan.webstore.order.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
	private int id;
	private int orderid;
	private int spuid;
	private String skuid;
	private double price;
	private int number;
	private int score;
}
