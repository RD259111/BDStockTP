package persistance.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import persistance.entities.Client;

public class ClientDaoImpl implements GlobalDao<Client> {

	@Override
	public Client findById(Client c) {
		return null;
	}

	@Override
	public Client findById(int id) {
		Client client = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			client = session.get(Client.class, id);
		}
		return client;
	}

	@Override
	public List<Client> findAll() {
		List<Client> listClients = new ArrayList<Client>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			listClients = session.createQuery("from Client").list();
		}
		return listClients;
	}

}
