package com.saga.app.controller.human;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saga.app.controller.home.HomeController;
import com.saga.model.dto.HumanResource;
import com.saga.model.service.HumanResourceService;
import com.saga.web.util.WebServletPath;

@Controller("humanResourceController")
@RequestMapping(value=WebServletPath.HR_PATH)
public class HumanResourceController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String HumanResourceDTO = "hr";
	@Autowired HumanResourceService humanResourceService; 
	
	@RequestMapping(value = WebServletPath.HR_SAVE , method = RequestMethod.GET)
	public ModelAndView inputInfo(@ModelAttribute HumanResource hr){
		ModelAndView mnv = new ModelAndView();
		mnv.addObject(HumanResourceDTO,hr);	
		mnv.setViewName("result/input");
		return mnv;
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
	
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
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
		logger.info("{}" , hr);
		humanResourceService.deleteMember(hr);
		
		mnv.addObject(HumanResourceDTO,hr);
		mnv.setViewName("redirect:/");
		return mnv; 
	}
}
