package nju.yufan.webstore.cart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nju.yufan.webstore.cart.entity.CartItem;
import nju.yufan.webstore.cart.vo.CartItemVo;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class CartItem1 {
	private int id;
	private int storeid;
	private int spuid;
	private String skuid;
	private String goodsname;
	private String sku;
	private String img;
	private double price;
	private int number;
	@JsonIgnore
	private Timestamp time;
	private boolean isStockEnough;

	public CartItem1(CartItem c, CartItemVo vo){
		this.id = c.getId();
		this.storeid = c.getStoreid();
		this.spuid = c.getSpuid();
		this.skuid = c.getSkuid();
		this.number = c.getNumber();
		this.time = c.getTime();
		this.goodsname = vo.getGoodsname();
		this.sku = vo.getSku();
		this.img = vo.getImgURL();
		this.price = vo.getPrice();
		this.isStockEnough = vo.isStockEnough();
	}
}
