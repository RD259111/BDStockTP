package persistance.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public interface GlobalDao<T> {

	default void add(T value) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			session.save(value);
			tx.commit();
		}

	};

	default void delete(T value) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			session.delete(value);
			tx.commit();
		}
	};

	default void update(T value) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			session.update(value);
			tx.commit();
		}
	};

	T findById(int id);

	T findById(T object);

	List<T> findAll();
}