package nju.yufan.webstore.comment.model;

import lombok.Getter;
import lombok.Setter;
import nju.yufan.webstore.comment.entity.Comment;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class OrderItemWithComments {
	private int id;
	private String skuid;
	private int userid;
	private Timestamp time;
	List<Comment> comments;
}
