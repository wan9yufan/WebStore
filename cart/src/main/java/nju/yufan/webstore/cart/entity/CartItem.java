package nju.yufan.webstore.cart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
public class CartItem {
	private int id;
	private int userid;
	private int storeid;
	private int spuid;
	private String skuid;
	private int number;
	@JsonIgnore
	private Timestamp time;
}
