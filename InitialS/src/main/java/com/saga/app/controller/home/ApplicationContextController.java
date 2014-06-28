package com.saga.app.controller.home;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.saga.model.service.HumanResourceService;

/**
 * @author simjisung
 * @see 위 방식은 Bean 을 자동 등록 하는 방식으로, 굉장히 잘 사용하지 않는 방식이다. 하지만 
 * 때에 따라서, 원하는 서비스를 미리 올려놓고 써야 할 경우가 있을때는 올려놓고 써도 된다. 
 * 하지만 토비사마가 권장하지 않는 방법 중 하나다. 현재 우리 사이트가 빈 자동 등록을 사용하고 쓰기때문에,
 * 성능적 퍼포먼스 사이드에서 굉장히 느린것 이다. 
 */
public class ApplicationContextController implements InitializingBean{
	@Autowired protected ApplicationContext applicationContext;
	protected static HumanResourceService humanResourceService;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		humanResourceService = applicationContext.getBean(HumanResourceService.class);		
	}
	
}
