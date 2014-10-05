import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Entity
@Table(name="roles")
@NamedQuery(name="roles.findAll", query="SELECT r FROM roles r")
public class projectTrial {

	EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}
	
	org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter adap = new HibernateJpaVendorAdapter();
	
	public List<String> getRoles() {
		Query query = em.createNativeQuery("Select * from roles");
		List<String> results = (List<String> )query.getResultList();
		return results;
	}
	
	public String trymeho() {
		
		return null;
	}
	
}
