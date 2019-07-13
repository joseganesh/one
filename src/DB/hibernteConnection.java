package DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jewellery.model.ProductModel;

public class hibernteConnection {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();

	public ProductModel getProducts() {
		session.beginTransaction();

		try {
			return (ProductModel) session.createQuery("FROM ProductModel WHERE productId=3").uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
