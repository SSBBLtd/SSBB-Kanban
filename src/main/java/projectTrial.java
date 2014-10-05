import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Entity
@Table(name="roles")
//@NamedQuery(name="roles.findAll", query="SELECT r FROM roles r")
public class projectTrial {


	
	
	/*public List<String> getRoles() {
		Query query = em.createNativeQuery("Select * from roles");
		List<String> results = (List<String> )query.getResultList();
		return results;
	}*/
	
	public String trymeho() {
		
		return null;
	}
	@Id
	@Column(name = "role_id")
	public int id;
}
