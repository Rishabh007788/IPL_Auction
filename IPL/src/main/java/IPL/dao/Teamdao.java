package IPL.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.dto.ManagementDto;
import IPL.dto.Team;

@Component
public class Teamdao {

	@Autowired
	EntityManager entityManager;
	 
	
	
	
	public void save(Team team) 
	{
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(team);
		entityTransaction.commit();
	}
	public Team fetch(String username) {
		List<Team> list = entityManager.createQuery("select x from Team x where username=?1").setParameter(1, username).getResultList();
		
		if(list.isEmpty()) {
			return null;
		}
		else {
			return list.getFirst();
		}
	}
	public List<Team> view_all_teams() {
		List<Team> teams = entityManager.createQuery("select x from Team x").getResultList();
		return teams;
	}
	
	public Team changestatus(int id) {
		Team team=entityManager.find(Team.class, id);
		return team;
	}
	
	public void update(Team team) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(team);
		entityTransaction.commit();
	}
}










