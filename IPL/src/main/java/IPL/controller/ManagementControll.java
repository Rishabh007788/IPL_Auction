package IPL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.ManagementDao;
import IPL.dto.ManagementDto;

@Controller
public class ManagementControll {
	@Autowired
	ManagementDao managementDao
	;
	ModelAndView andView = new ModelAndView();
	@RequestMapping("management_signup")
	@ResponseBody
	ModelAndView managementSignup(@ModelAttribute ManagementDto managementDto){
		managementDao.save(managementDto);
		
		andView.addObject("msg", "account created");
		andView.setViewName("managerlogin.jsp"); 
		return andView; 
	}
	
	
	@PostMapping("management_login")
	@ResponseBody
	public ModelAndView login(@RequestParam String name, @RequestParam String password) {
		ManagementDto managementDto =managementDao.login(name);
		if (managementDto!=null) {
			if (managementDto.getName().equals(name)&& managementDto.getPassword().equals(password)) {
				
				andView.addObject("msg", "login succesful");
				andView.setViewName("managementHome.jsp");
				
			} else {
				andView.addObject("msg", "name or password doesn,t match");
				andView.setViewName("managerlogin.jsp");
			}
		} else {
			andView.addObject("msg", "not found");
			andView.setViewName("managerlogin.jsp");
		}
		
		return andView;
	}
	
	
}
