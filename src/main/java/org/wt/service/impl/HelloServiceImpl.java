package org.wt.service.impl;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.wt.Dog;
import org.wt.service.HelloService;
@Service("helloService")
//该lazy会失效，原因并不是被controller依赖，而是它是dubbo服务。
@Lazy(true)
public class HelloServiceImpl implements HelloService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@PostConstruct
	public void init(){
		System.out.println(this.getClass().getName());
		Method[] methods = this.getClass().getDeclaredMethods();
		System.out.println(methods);
		String res = new Dog().wang("xiaoming");
		System.out.println(res);
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

	@Override
	public Dog helloDog() {
		return new Dog();
	}

}
