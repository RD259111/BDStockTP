package persistance.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import persistance.entities.Categorie;

public class CategorieDaoImpl implements GlobalDao<Categorie> {

	@Override
	public Categorie findById(Categorie c) {
		return null;
	}

	@Override
	public Categorie findById(int id) {
		Categorie categorie = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			categorie = session.get(Categorie.class, id);
		}
		return categorie;
	}

	@Override
	public List<Categorie> findAll() {
		List<Categorie> listCategories = new ArrayList<Categorie>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			listCategories = session.createQuery("from Categorie").list();
		}
		return listCategories;
	}

}
