package com.groupeisi.dao;

import com.groupeisi.config.HibernateUtil;
import com.groupeisi.entity.ClasseEntity;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class ClasseDao extends RepositoryImpl<ClasseEntity> implements IClasseDao {

    public ClasseDao() {
        super(ClasseEntity.class);
    }

    @Override
    public Optional<ClasseEntity> findByCode(String code) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<ClasseEntity> cq = cb.createQuery(ClasseEntity.class);
            Root<ClasseEntity> root = cq.from(ClasseEntity.class);

            Predicate predicate = cb.equal(root.get("code"), code);
            cq.select(root).where(predicate);

            return Optional.ofNullable(session.createQuery(cq).uniqueResult());
        }
    }

    @Override
    public List<ClasseEntity> findBySectorId(int sectorId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<ClasseEntity> cq = cb.createQuery(ClasseEntity.class);
            Root<ClasseEntity> root = cq.from(ClasseEntity.class);

            // Création de la requête pour filtrer par l'ID du secteur
            Predicate predicate = cb.equal(root.get("sector").get("id"), sectorId);
            cq.select(root).where(predicate);

            return session.createQuery(cq).getResultList();
        }
    }
}