package nju.yufan.webstore.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nju.yufan.webstore.order.entity.OrderItem;
import nju.yufan.webstore.order.vo.OrderItemVo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem1 {
	private int id;
	private int spuid;
	private String name;
	private String sku;
	private String img;
	private double price;
	private int number;

	public OrderItem1(OrderItemVo vo, OrderItem item){
		this.id = item.getId();
		this.spuid = item.getSpuid();
		this.name = vo.getGoodsName();
		this.img = vo.getImgURL();
		this.sku = vo.getSku();
		this.price = item.getPrice();
		this.number = item.getNumber();
	}
}
