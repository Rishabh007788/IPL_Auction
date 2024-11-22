package IPL.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.dto.Player;

@Component
public class Playerdao {

	@Autowired
	EntityManager entityManager;
	
	public void save(Player player) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(player);
		entityTransaction.commit();
	}
	
	public void update(Player player) {
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(player);
		entityTransaction.commit();
	}
	
	public List<Player> fetchAll() {
		List<Player> players=entityManager.createQuery("select x from Player x").getResultList();
		return players;
	}
	
	public Player fetchOne(int id) {
		Player player=entityManager.find(Player.class, id);
		return player;
	}
	
	public List<Player> fetchAvailable() {
		List<Player> players=entityManager.createQuery("select x from Player x where status='Active'").getResultList();
		return players;
	}
}
