package org.wt.service.impl;

import java.lang.reflect.Method;
import java.util.*;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.wt.model.User;
import org.wt.service.UserService;
import org.wt.util.CryptUtils;

@Service("userService")
//该lazy会失效，原因并不是被controller依赖，而是它是dubbo服务。
@Lazy(true)
public class UserServiceImpl implements UserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private List<User> users = new ArrayList<>();
	@PostConstruct
	public void init(){
		logger.info("init "+this.getClass().getName());
		users.add(new User("mingren","123","吊车尾"));
		users.add(new User("zuozhu","456","二柱子"));
		users.add(new User("zilaiye","789","好色仙人"));
	}


	@Override
	public User login(String name, String password) {
		return users.stream().filter(u->{
			return Objects.equals(u.getName(),name) && Objects.equals(CryptUtils.enc(u.getPassword()),password);
		}).findFirst().orElse(new User("xxx","xxx","xxx"));
	}



}
