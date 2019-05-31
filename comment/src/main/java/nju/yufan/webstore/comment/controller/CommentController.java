package nju.yufan.webstore.comment.controller;

import nju.yufan.webstore.comment.entity.Comment;
import nju.yufan.webstore.comment.model.Comments4Order;
import nju.yufan.webstore.comment.service.RemoteGoodsService;
import nju.yufan.webstore.comment.service.RemoteUserService;
import nju.yufan.webstore.comment.model.CommentsOfUserForSpu;
import nju.yufan.webstore.comment.model.OrderItemWithComments;
import nju.yufan.webstore.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	@Autowired
	private RemoteGoodsService goodsService;
	@Autowired
	private RemoteUserService userService;

	@RequestMapping("/insert")
	public void insert(Comment comment) {
		commentService.insert(comment);
	}

	@RequestMapping("/commentOrder")
	@Transactional
	public void CommentOrder(Comments4Order comment) {
		commentService.commentOrder(comment);
	}

	@RequestMapping("/reply")
	public void reply(int id, String reply) {
		commentService.reply(id,reply);
	}

	@RequestMapping("/getCommentsOfSPU")
	public List<CommentsOfUserForSpu> getCommentsOfSPU(int spuid) {
		List<OrderItemWithComments> items =  commentService.getRawCommentsOfSPU(spuid);
		List<Integer> useridList = items.stream().map(OrderItemWithComments::getUserid).collect(Collectors.toList());
		List<String> usernameList = userService.getUserNames(useridList);
		List<String> skuidList = items.stream().map(OrderItemWithComments::getSkuid).collect(Collectors.toList());
		List<String> skus = goodsService.getSkus(skuidList);
		List<CommentsOfUserForSpu> result = new ArrayList<>(items.size());
		CommentsOfUserForSpu commentsOfUserForSpu;
		for(int i = 0; i < items.size(); i++){
			commentsOfUserForSpu = new CommentsOfUserForSpu(items.get(i));
			commentsOfUserForSpu.getComments().sort(Comparator.comparing(Comment::getTime).reversed());
			commentsOfUserForSpu.setUserName(usernameList.get(i));
			commentsOfUserForSpu.setSku(skus.get(i));
			result.add(commentsOfUserForSpu);
		}
		result.sort(Comparator.comparing(CommentsOfUserForSpu::getTime).reversed());
		return result;
	}

	@RequestMapping("/getScoreOfSPU")
	public double getAverageScoreOfSPU(int spuid){
		return commentService.getAverageScoreOfSPU(spuid);
	}

	@RequestMapping("/getScoresOfStore")
	public List<Double> getScoresOfStore(int storeid) {
		return commentService.getScoresOfStore(storeid);
	}


}
