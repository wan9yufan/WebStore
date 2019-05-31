package nju.yufan.webstore.comment.service;

import nju.yufan.webstore.comment.entity.Comment;
import nju.yufan.webstore.comment.model.Comments4Order;
import nju.yufan.webstore.comment.model.OrderItemWithComments;

import java.util.List;

public interface CommentService {
	void insert(Comment comment);
	void commentOrder(Comments4Order comment);
	void reply(int id,String reply);
	List<OrderItemWithComments> getRawCommentsOfSPU(int spuid);
	double getAverageScoreOfSPU(int spuid);
	List<Double> getScoresOfStore(int storeid);
}
