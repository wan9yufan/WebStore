package nju.yufan.webstore.cart.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemVo {
	private String sku;
	private String goodsname;
	private String imgURL;
	private double price;
	//库存数量
	private boolean isStockEnough;
}
