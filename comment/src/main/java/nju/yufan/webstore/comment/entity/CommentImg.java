package nju.yufan.webstore.comment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentImg {
	@JsonIgnore
	private int id;
	@JsonIgnore
	private int commentId;
	private String url;

	public CommentImg(int commentId, String url) {
		this.commentId = commentId;
		this.url = url;
	}
}
