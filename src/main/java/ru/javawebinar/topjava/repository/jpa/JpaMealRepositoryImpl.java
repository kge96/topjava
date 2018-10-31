package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepositoryImpl implements MealRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            em.persist(meal);
            return meal;
        } else {
            return em.merge(meal);
        }
    }

    @Override
    public boolean delete(int id, int userId) {
        Query q = em.createQuery("DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId");
        return q.setParameter("id", id).executeUpdate() != 0;
    }

    @Override
    public Meal get(int id, int userId) {
        return (Meal) em.createQuery("select Meal from Meal as m where m.id=:id and m.user.id=:userId");
    }

    @Override
    public List<Meal> getAll(int userId) {
        return em.createQuery("select m from Meal as m order by m.dateTime").getResultList();
    }

    @Override
    public List<Meal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return em.createQuery("select m from Meal as m where m.user.id=:userId and m.dateTime>:startDate and m.dateTime<=:endDate order by m.dateTime desc").getResultList();
    }
}