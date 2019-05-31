package nju.yufan.webstore.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Order {
	private int id;
	private int userid;
	private int storeid;
	private int addressid;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Timestamp time;
	private double money;
	private int status;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Timestamp arriveTime;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Timestamp receiveTime;
	private int serviceScore;
	private int transportScore;
	private boolean commented;
	private List<OrderItem> items;

	public Order(int userid, int storeid, int addressid, double money, int status) {
		this.userid = userid;
		this.storeid = storeid;
		this.addressid = addressid;
		this.money = money;
		this.status = status;
	}
}
