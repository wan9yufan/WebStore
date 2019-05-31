package nju.yufan.webstore.order.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemVo {
	//具体规格，形式为 “规格名:规格值”，多个键值对之间用；隔开
	private String sku;
	private String imgURL;
	private String goodsName;
}