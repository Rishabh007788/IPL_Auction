package IPL.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import IPL.dto.ManagementDto;
import java.util.List;

@Component
public class ManagementDao {
	
	@Autowired
	EntityManager entityManager;
	
public void save(ManagementDto managementDto) {
	EntityTransaction entityTransaction = entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(managementDto);
	entityTransaction.commit();
	
}

public ManagementDto login(String name) {
    List<ManagementDto> managerList = entityManager.createQuery("SELECT x FROM ManagementDto x WHERE name = ?1", ManagementDto.class)
            .setParameter(1, name)
            .getResultList();

    if (!managerList.isEmpty()) {
        return managerList.get(0);
    } else {
        return null;
    }
}


}
