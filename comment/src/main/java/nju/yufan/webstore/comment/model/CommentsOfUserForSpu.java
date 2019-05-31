package nju.yufan.webstore.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nju.yufan.webstore.comment.entity.Comment;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CommentsOfUserForSpu {
	private String sku;
	private String userName;
	@JsonIgnore
	private Timestamp time;
	List<Comment> comments;

	public CommentsOfUserForSpu(OrderItemWithComments itemWithComments){
		this.time = itemWithComments.getTime();
		this.comments = itemWithComments.getComments();
	}
}
