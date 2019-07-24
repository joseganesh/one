package queryHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jewellery.model.ProductModel;
import org.jewellery.model.SalesScreenModel;

public class jewelHibernate {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();

	@SuppressWarnings("unchecked")
	public List<ProductModel> getsalesinvoice(int SalesScreenId) {
		session.beginTransaction();
		try {
			return session.createQuery("from ProductModel where SalesScreenId=:SalesScreenId")
					.setParameter("SalesScreenId", SalesScreenId).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
