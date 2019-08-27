package org.wt.web;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wt.context.AppContextHolder;
import org.wt.model.User;
import org.wt.service.RemoteUserService;
import org.wt.service.UserService;
import org.wt.service.impl.OrderServiceImpl;

@RequestMapping
//@Lazy(true)
@Controller
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private RemoteUserService remoteUserService;

	@PostConstruct
	public void init(){
		System.out.println(this.getClass().getName()+" init...");
		System.out.println(AppContextHolder.getAppContext());
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public JSONObject login(String name, String password, HttpSession session){
		User user = userService.login(name,password);
		session.setAttribute("currrentUser",user);
		JSONObject res = new JSONObject();
		res.put("code","SUCCESS");
		res.put("msg","success");
		res.put("whosyourdaddy",session.getAttribute("whosyourdaddy"));
		res.put("user",user);
		System.out.println(user.getName());
		return res;
	}
	@ResponseBody
	@RequestMapping("/remote-login")
	public JSONObject remoteLogin(String name, String password, HttpSession session){
		User user = remoteUserService.login(name,password);
		session.setAttribute("currrentUser",user);
		JSONObject res = new JSONObject();
		res.put("code","SUCCESS");
		res.put("msg","remote login success");
		res.put("user",user);
		return res;
	}
}
