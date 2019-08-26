package org.wt.service;

import org.wt.model.User;

public interface UserService {

	User login(String name, String password);
}
