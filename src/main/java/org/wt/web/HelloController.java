package org.wt.web;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wt.Dog;
import org.wt.service.HelloService;
import org.wt.service.impl.HelloServiceImpl;

@RequestMapping
//@Lazy(true)
@Controller
public class HelloController {
	@Resource
	private HelloService helloService;
	@PostConstruct
	public void init(){
		System.out.println(this.getClass().getName()+" init...");
	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public Object hello(String name){
		ClassLoader cxtCl= Thread.currentThread().getContextClassLoader();
		System.out.println(cxtCl);
		ClassLoader cl = Dog.class.getClassLoader();
		System.out.println(cl);
		return new Dog().wang(name);
		//return helloService.hello(name);
	}
}
