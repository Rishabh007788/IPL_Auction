package IPL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dto.ManagementDto;
import IPL.dto.Player;
import IPL.dto.Team;

@Controller
public class Controll {
	
	@Autowired
	ManagementDto managementdto;
	
	@Autowired
	Team team;
	
	@Autowired
	Player player;
	
	@RequestMapping("signup")
	@ResponseBody
	public ModelAndView signupp(@RequestParam String role)//@RequestParam work like req.getparameter(). it receives the data from front-tend one by one.
	{
		ModelAndView andView = new ModelAndView();
		if (role.equals("management")) {
			andView.addObject("management",managementdto);
			andView.setViewName("managementSignup.jsp");
		}
		else if (role.equals("team")) {
			andView.addObject("team", team);
			andView.setViewName("teamsignup.jsp");
		}
		else if (role.equals("player")) {
			andView.addObject("player", player);
			andView.setViewName("playersignup.jsp");
		}
		return andView;
	}
	
}
 