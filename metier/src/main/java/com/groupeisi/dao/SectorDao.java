package com.groupeisi.dao;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.groupeisi.config.HibernateUtil;
import com.groupeisi.entity.SectorEntity;

public class SectorDao extends RepositoryImpl<SectorEntity> implements ISectorDao {

    public SectorDao() {
        super(SectorEntity.class);
    }

    // Exemple : rechercher un secteur par nom
    public Optional<SectorEntity> findByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<SectorEntity> cq = cb.createQuery(SectorEntity.class);
            Root<SectorEntity> root = cq.from(SectorEntity.class);

            Predicate predicate = cb.equal(root.get("name"), name);
            cq.select(root).where(predicate);

            return Optional.ofNullable(session.createQuery(cq).uniqueResult());
        }
    }
}