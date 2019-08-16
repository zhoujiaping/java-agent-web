package org.wt.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wt.service.HelloService;
import org.wt.service.impl.HelloServiceImpl;

@RequestMapping
@Controller
public class HelloController {
	@Resource
	private HelloService helloService;
	
	@ResponseBody
	@RequestMapping("/hello")
	public Object hello(String name){
		HelloServiceImpl h = new HelloServiceImpl();
		h.hello();
		h.hello(" world");
		helloService.hello();
		return helloService.hello(name);
	}
}
