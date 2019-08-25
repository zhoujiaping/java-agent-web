package org.wt.service;

import org.wt.model.User;

public interface RemoteUserService {
    User login(String name, String password);
}
