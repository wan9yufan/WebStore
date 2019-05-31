package nju.yufan.webstore.order.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AfterSale {
	private int orderItemId;
	private String  reason;
	private String express;
	private boolean finished;
}
