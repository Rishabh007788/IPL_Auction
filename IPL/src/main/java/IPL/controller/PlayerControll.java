package IPL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.Playerdao;
import IPL.dto.Player;

@Controller
public class PlayerControll {
	
	@Autowired
	Playerdao playerdao;

	@PostMapping("player_signup")
	@ResponseBody
	public ModelAndView playersignup(@ModelAttribute Player player) {
		
		playerdao.save(player);
		
		ModelAndView andView = new ModelAndView();
		andView.addObject("msg", "your account is created");
		andView.setViewName("playerlogin.jsp");
		
		return andView;
				
	}
	@RequestMapping("viewAllplayers")
	@ResponseBody
	public ModelAndView viewAllPlayers() {
		List<Player> players = playerdao.fetchAll();
		
		ModelAndView andView = new ModelAndView();
		andView.addObject("players",players);
		andView.setViewName("viewallplayers.jsp");
		return andView;
	}
	
	@RequestMapping("change_pstatus")
	@ResponseBody
	public ModelAndView changeStatus(@RequestParam int id) {
		Player player = playerdao.fetchOne(id);
		
		if (player.getStatus()==null) {
			player.setStatus("Active");
		} else {
			player.setStatus(null);
		}
		
		playerdao.update(player);
		List<Player> players = playerdao.fetchAll();
		
		ModelAndView andView = new ModelAndView();
		andView.addObject("players",players);
		andView.setViewName("viewallplayers.jsp");
		return andView;
				
	}
	
	@RequestMapping("view_available_players")
	@ResponseBody
	public ModelAndView viewAvailablePlayers() {
		List<Player> players = playerdao.fetchAvailable();
		ModelAndView andView = new ModelAndView();
		if (players.isEmpty()) {
			andView.addObject("msg","no players available");
			andView.setViewName("teamhome.jsp");
		} else {
			andView.addObject("players",players);
			andView.setViewName("buyplayers.jsp");
		}
		
		return andView;
	}

}
