package persistance.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import persistance.entities.Commande;

public class CommandeDaoImpl implements GlobalDao<Commande> {

	@Override
	public Commande findById(int id) {
		return null;
	}

	@Override
	public Commande findById(Commande c) {
		Commande commande = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			commande = session.get(Commande.class, c.getId());
		}
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		List<Commande> listCommandes = new ArrayList<Commande>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			listCommandes = session.createQuery("from Commande").list();
		}
		return listCommandes;
	}

}