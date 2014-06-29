package com.saga.app.controller.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saga.model.dto.HumanResource;
import com.saga.model.service.HumanResourceService;
import com.saga.web.util.WebServletPath;

/**
 * @author simjisung
 * @see @autoaired 로 주입 받은 서비스를 가지고 , 서비스 로직을 사용해 보았다. 
 * 현재 이 컨트롤러는 HumanResource 를 기반으로, 간단한 CRUD 을 가지고, 간단한 컨트롤러 구성해본 컨트롤러.
 */
@Controller
public class HomeController{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	
	
	
	
}
