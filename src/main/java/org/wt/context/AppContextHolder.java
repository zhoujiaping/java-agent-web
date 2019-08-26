package org.wt.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppContextHolder {
    private static ApplicationContext appContext;
    @Autowired
    public void setAppContext(ApplicationContext appContext){
        AppContextHolder.appContext = appContext;
    }
    public static ApplicationContext getAppContext() {
        return appContext;
    }
}
