package com.groupeisi.dao;

import com.groupeisi.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RepositoryImpl<T> implements Repository<T> {

	// On stocke le type de l'entité ici pour l'utiliser dans les méthodes
	private final Class<T> entityClass;

	// Le constructeur prend le type de l'entité en paramètre
	public RepositoryImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public boolean save(T t) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			T entity = session.get(entityClass, id); // Utilisation de l'entityClass et de l'id int
			if (entity != null) {
				session.delete(entity);
				transaction.commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(T t) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(t);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<T> list() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<T> cq = cb.createQuery(entityClass);
			Root<T> root = cq.from(entityClass);
			cq.select(root);
			return session.createQuery(cq).getResultList();
		}
	}

	@Override
	public T get(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(entityClass, id);
		}
	}
}