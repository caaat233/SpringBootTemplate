package com.springboottemplate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.support.json.JSONUtils;
import com.springboottemplate.annontation.LogTestAnno;
import com.springboottemplate.pojo.User;
import com.springboottemplate.util.Consumer;
import com.springboottemplate.util.JmsConfig;
import com.springboottemplate.util.Producer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboottemplate.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	Executor executor;

	@Autowired
	private Producer producer;

	public static  final  ThreadLocal<String> threadLocal=new ThreadLocal();
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	/**
	 * http://127.0.0.1:8082/text/rocketmq
	 * 测试mq
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/text/rocketmq")
	public Object callback() throws Exception {
		List<String> mesList = new ArrayList<>();
		mesList.add("小小");
		mesList.add("爸爸");
		mesList.add("妈妈");
		mesList.add("爷爷");
		mesList.add("奶奶");
		//总共发送五次消息
		for (String s : mesList) {
			//创建生产信息
			Message message = new Message(JmsConfig.TOPIC, "testtag", ("小小一家人的称谓:" + s).getBytes());
			//发送
			SendResult sendResult = producer.getProducer().send(message);
			logger.info("输出生产者信息={}",sendResult);
		}
		return "list";
	}


	@RequestMapping("user")
	public String findAllUser(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("userList", userService.findAll());
		// 设置了转发的前缀后缀了已经，直接写这个页面即可
		for (int i = 1; i <= 10; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {

				}
			});
		}
		return "list";
	}

	@RequestMapping("userResponseBody")
	@ResponseBody
	public String findAllUser1(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("userList", userService.findAll());
		// 设置了转发的前缀后缀了已经，直接写这个页面即可
		return userService.findAll().toString();
	}

	/**
	 * 直接向页面响应数据
	 * @param request
	 * @param response
	 * @return
	 */
	@LogTestAnno(name="映射得url：findAllUser2")
	@RequestMapping("findAllUser2")
	@ResponseBody
	public String findAllUser2(HttpServletRequest request, HttpServletResponse response) throws InterruptedException {
		threadLocal.set("张三"+Math.random());
		request.setAttribute("userList", userService.findAll());
		Thread.sleep(5000);
		User user=new User();
		user.setArea("qqq");
		user.setName("张三");
		return user.toString();
	}
}
