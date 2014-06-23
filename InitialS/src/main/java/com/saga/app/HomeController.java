package com.saga.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saga.model.dto.HumanResource;
import com.saga.web.util.WebServletPath;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends ApplicationContextController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String HumanResourceDTO = "hr";
 
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
		
		/*HumanResource DTO */
		HumanResource hr = new HumanResource();
		model.addAttribute(HumanResourceDTO,hr);
		return "home";
	}
	
	
	@RequestMapping(value = WebServletPath.HR_SAVE , method = RequestMethod.POST)
	public ModelAndView saveInfo(@ModelAttribute HumanResource hr){
		ModelAndView mnv = new ModelAndView();
		
		humanResourceService.addMemeber(hr);
		
		logger.info("{}" , hr);
		
		mnv.addObject(HumanResourceDTO,hr);	
		mnv.setViewName("result/result");
		return mnv;
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public ModelAndView viewById(@PathVariable("id") Integer id){
		ModelAndView mnv = new ModelAndView();
		
		HumanResource hr = humanResourceService.findById(id);
		
		logger.info("{}" , hr);
		 
		mnv.addObject(HumanResourceDTO,hr);
		mnv.setViewName("result/viewById");
		return mnv;
	}
	
	@RequestMapping(value = WebServletPath.HR_UPDATE , method = RequestMethod.POST)
	public ModelAndView updateInfo(@ModelAttribute HumanResource hr){
		ModelAndView mnv = new ModelAndView();
		
		logger.info("{}" , hr);
		
		humanResourceService.updateMember(hr);
		
		mnv.addObject(HumanResourceDTO,hr);
		mnv.setViewName("redirect:/");
		return mnv;
	}
	
	@RequestMapping(value = WebServletPath.HR_ALL_VIEW, method=RequestMethod.GET)
	public ModelAndView allView(){
		
		ModelAndView mnv = new ModelAndView();
		List<HumanResource> list = humanResourceService.findAll();
		
		mnv.addObject("LIST", list);
		mnv.setViewName("result/allview");
		
		return mnv;	
	}
	
	@RequestMapping(value = WebServletPath.HR_DELETE , method = RequestMethod.POST)
	public ModelAndView deleteById(@ModelAttribute HumanResource hr){
		ModelAndView mnv = new ModelAndView();
		
		humanResourceService.deleteMember(hr);
		
		mnv.addObject(HumanResourceDTO,hr);
		mnv.setViewName("redirect:/");
		return mnv; 
	}
	
	
}
