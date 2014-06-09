package com.saga.app;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.saga.model.service.HumanResourceService;

public class ApplicationContextController implements InitializingBean{
	@Autowired protected ApplicationContext applicationContext;
	protected static HumanResourceService humanResourceService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		humanResourceService = applicationContext.getBean(HumanResourceService.class);		
	}
	
}
