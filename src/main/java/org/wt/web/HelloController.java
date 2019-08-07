package org.wt.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wt.service.HelloService;

import javassist.ClassPool;

@RequestMapping
@Controller
public class HelloController {
	@Resource
	private HelloService helloService;
	
	@ResponseBody
	@RequestMapping("/hello")
	public Object hello(String name){
		new ClassPool();
		return helloService.hello(name);
	}
}
