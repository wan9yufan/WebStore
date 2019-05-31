package nju.yufan.webstore.comment.service;

import nju.yufan.webstore.comment.dao.CommentDao;
import nju.yufan.webstore.comment.entity.Comment;
import nju.yufan.webstore.comment.model.Comments4Order;
import nju.yufan.webstore.comment.model.Comment4OrderItem;
import nju.yufan.webstore.comment.model.OrderItemWithComments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	@Transactional
	public void insert(Comment comment) {
		commentDao.insert(comment);
		commentDao.insertImgs(comment.getImgs());
	}

	@Override
	@Transactional
	public void commentOrder(Comments4Order comment) {
		commentDao.rateOrder(comment.getOrderid(), comment.getServiceScore(),comment.getTransportScore());
		for(Comment4OrderItem c : comment.getComments()){
			commentDao.rateOrderItem(c.getComment().getOrderItemId(),c.getScore());
			commentDao.insert(c.getComment());
			commentDao.insertImgs(c.getComment().getImgs());
		}
	}

	@Override
	public void reply(int id, String reply) {
		commentDao.reply(id, reply);
	}

	@Override
	public List<OrderItemWithComments> getRawCommentsOfSPU(int spuid) {
		return commentDao.getCommentsOfSPU(spuid).stream().sorted(Comparator.comparing(OrderItemWithComments::getTime).reversed()).collect(Collectors.toList());
	}

	@Override
	public double getAverageScoreOfSPU(int spuid) {
		return commentDao.getAverageScoreOfSPU(spuid);
	}

	@Override
	public List<Double> getScoresOfStore(int storeid) {
		List<Double> list = new ArrayList<>();
		list.add(commentDao.getGoodsScoreOfStore(storeid));
		list.add(commentDao.getServiceScoreOfStore(storeid));
		list.add(commentDao.getTransportScoreOfStore(storeid));
		return list;
	}
}
