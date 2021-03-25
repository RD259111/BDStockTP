package persistance.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import persistance.entities.Produit;

public class ProduitDaoImpl implements GlobalDao<Produit> {

	@Override
	public Produit findById(Produit p) {
		return null;
	}

	@Override
	public Produit findById(int id) {
		Produit produit = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			produit = session.get(Produit.class, id);
		}
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		List<Produit> listProduits = new ArrayList<Produit>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			listProduits = session.createQuery("from Produit").list();
		}
		return listProduits;
	}

}