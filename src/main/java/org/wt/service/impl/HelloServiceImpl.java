package org.wt.service.impl;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.wt.service.HelloService;
@Service("helloService")
//该lazy会失效，原因并不是被controller依赖，而是它是dubbo服务。
@Lazy(true)
public class HelloServiceImpl implements HelloService{
	@PostConstruct
	public void init(){
		System.out.println(this.getClass().getName());
		Method[] methods = this.getClass().getDeclaredMethods();
		System.out.println(methods);
	}
	@Override
	public String hello(String name) {
		System.out.println("执行原方法hello(String name)");
		return "hello "+name;
	}
	@Override
	public String hello() {
		System.out.println("执行原方法hello()");
		return "hello()";
	}

}
