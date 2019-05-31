package nju.yufan.webstore.comment.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Comments4Order {
	private int orderid;
	private int serviceScore;
	private int transportScore;
	List<Comment4OrderItem> comments;
}
