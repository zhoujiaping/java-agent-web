package org.wt.service.impl;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.wt.service.HelloService;
@Service("helloService")
public class HelloServiceImpl implements HelloService{
	@PostConstruct
	public void init(){
		System.out.println(this.getClass().getName());
		Method[] methods = this.getClass().getDeclaredMethods();
		System.out.println(methods);
	}
	@Override
	public String hello(String name) {
		return "hello "+name;
	}

}
