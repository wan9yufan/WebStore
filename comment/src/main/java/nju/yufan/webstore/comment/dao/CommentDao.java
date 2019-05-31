package nju.yufan.webstore.comment.dao;

import nju.yufan.webstore.comment.entity.Comment;
import nju.yufan.webstore.comment.entity.CommentImg;
import nju.yufan.webstore.comment.model.OrderItemWithComments;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
	void insert(Comment comment);
	void reply(int id,String reply);
	void insertImgs(List<CommentImg> imgs);
	List<OrderItemWithComments> getCommentsOfSPU(int spuid);
	double getAverageScoreOfSPU(int spuid);
	double getGoodsScoreOfStore(int storeid);
	double getServiceScoreOfStore(int storeid);
	double getTransportScoreOfStore(int storeid);
	void rateOrder(int orderid, int serviceScore, int transportScore);
	void rateOrderItem(int orderItemId, int score);

}
