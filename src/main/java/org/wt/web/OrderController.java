package org.wt.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wt.context.AppContextHolder;
import org.wt.model.Order;
import org.wt.model.User;
import org.wt.service.RemoteUserService;
import org.wt.service.UserService;
import org.wt.service.impl.OrderServiceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping
//@Lazy(true)
@Controller
public class OrderController {

	@Resource
	private OrderServiceImpl orderService;
	@PostConstruct
	public void init(){
	}
	
	@ResponseBody
	@RequestMapping("/orders")
	public JSONObject orders(){
		List<Order> orders = orderService.queryAllOrders();
		JSONObject res = new JSONObject();
		res.put("code","SUCCESS");
		res.put("msg","success");
		res.put("orders",orders);
		return res;
	}

}
