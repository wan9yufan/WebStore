package nju.yufan.webstore.comment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Comment {
	private int id;
	private int orderItemId;
	private String comment;
	private String reply;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Timestamp time;
	List<CommentImg> imgs;

	public Comment(int orderItemId, String comment) {
		this.orderItemId = orderItemId;
		this.comment = comment;
	}
}
