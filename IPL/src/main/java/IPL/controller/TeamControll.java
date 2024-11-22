package IPL.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import IPL.dao.Playerdao;
import IPL.dao.Teamdao;
import IPL.dto.Player;
import IPL.dto.Team;

@Controller
public class TeamControll {

	@Autowired
	Teamdao teamdao;
	
	@Autowired
	Playerdao playerdao;

	ModelAndView andView = new ModelAndView();

	@RequestMapping("team_signup")
	@ResponseBody
	public ModelAndView signupcontroll(@ModelAttribute Team team) {
		teamdao.save(team);

		andView.addObject("msg", "team account created");
		andView.setViewName("teamlogin.jsp");
		return andView;
	}

	@RequestMapping("team_ligin")
	@ResponseBody
	public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpSession session) {
		Team team = teamdao.fetch(username);

		if (team != null && team.getUsername().equals(username) && team.getPassword().equals(password)) {
			session.setAttribute("team", team);
			
			if (team.isStatus() == true) {
				andView.addObject("msg", "welcome team "+team.getName()+" to the IPL Auction");
				andView.addObject("img", team.getImagelink());
				andView.setViewName("teamhome.jsp");
				return andView;
			} else {
				andView.addObject("msg", "your account is not approved <br> wait for management approval");
				andView.setViewName("teamlogin.jsp");
				return andView;
			}

		} else {

			andView.addObject("msg", "invalid username or password");
			andView.setViewName("teamlogin.jsp");
			return andView;
		}
	}

	@ResponseBody

	@RequestMapping("viewAllteams")

	public ModelAndView viewAllteam() {

		List<Team> teams = teamdao.view_all_teams();

		ModelAndView modelAndView = new ModelAndView();

		if (teams.isEmpty()) {

			modelAndView.addObject("msg", "There are no teams presented inside database");

			modelAndView.setViewName("ManagementHome.jsp");

		}

		else

		{

			modelAndView.addObject("teams", teams);

			modelAndView.setViewName("viewallteams.jsp");

		}

		return modelAndView;

	}

	@RequestMapping("change_status")
	@ResponseBody
	public ModelAndView changestatus(@RequestParam int id) {
		Team team = teamdao.changestatus(id);
		if (team.isStatus()) {
			team.setStatus(false);
		} else {
			team.setStatus(true);
		}

		teamdao.update(team);
		List<Team> list = teamdao.view_all_teams();

		andView.addObject("teams", list);
		andView.setViewName("viewallteams.jsp");
		return andView;
	}

	@RequestMapping("addamount")
	@ResponseBody
	public ModelAndView addAmount(@RequestParam int id, @RequestParam double amount) {
		Team team = teamdao.changestatus(id);
		if (team.isStatus()) {
			team.setWallet(team.getWallet() + amount);
		} else {
			andView.addObject("errormsg", "team status is not active");
		}

		teamdao.update(team);
		List<Team> list = teamdao.view_all_teams();

		andView.addObject("teams", list);
		andView.setViewName("viewallteams.jsp");
		return andView;
	}
	
	@RequestMapping("buy_players")
	@ResponseBody
	public ModelAndView buyPlayer(@RequestParam int id, HttpSession session) {
		ModelAndView andView = new ModelAndView();
		Team team=(Team) session.getAttribute("team");
		Player player=playerdao.fetchOne(id);
		
		if (team.getWallet()>=player.getPrice()) 
		{
			team.setWallet(team.getWallet()-player.getPrice());
			player.setStatus("sold");
			
			List<Player> players=team.getPlayers();
			if (players==null) {
				players=new ArrayList<Player>();
			}
			players.add(player);
			team.setPlayers(players);
			
			player.setTeam(team);
			
			teamdao.update(team);
			playerdao.update(player);
			
			andView.addObject("msg", "purchased succesfully");
			
		} else {
			andView.addObject("msg", "insufficient balance");
			
		} 
		
		andView.setViewName("comres.jsp");
		return andView;
	}
	
	@RequestMapping("view_team")
	@ResponseBody
	public ModelAndView seeTeam(HttpSession session) {
		Team team=(Team) session.getAttribute("team");
		List<Player> players = team.getPlayers();
		ModelAndView andView = new ModelAndView();
		if (players.isEmpty()) {
			andView.addObject("msg","no player in your team");
			andView.setViewName("teamhome.jsp");
		} else {
			andView.addObject("players", players);
			andView.setViewName("viewteam.jsp");
		}
		return andView;
	}
	
	@RequestMapping("view_team_by_name")
	@ResponseBody
	public ModelAndView viewteams( HttpSession session) {
		ModelAndView andView = new ModelAndView();
		List<Team> teams = teamdao.view_all_teams();
		andView.addObject("teams", teams);
		andView.setViewName("viewteambyname.jsp");
		return andView;
	}
	@RequestMapping("view_selected_team")
	@ResponseBody
	public ModelAndView selectedTeam(@RequestParam String username) {
		Team team = teamdao.fetch(username);
		List<Player>players=team.getPlayers();
		List<Team> teams = teamdao.view_all_teams();
		ModelAndView andView = new ModelAndView();
		
		andView.addObject("selectedteam",team);
		if (players.isEmpty()) {
			andView.addObject("msg","no player in team");
		} else {
			andView.addObject("players", players);
		}
		andView.addObject("teams", teams);
		andView.setViewName("viewteambyname.jsp");
		return andView;
	}

}
