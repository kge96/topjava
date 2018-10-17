package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository repository;

    @Autowired
    public MealServiceImpl(MealRepository repository) {
        this.repository = repository;
    }

    @Override
    public Meal create(Meal meal, int userId) {
        return repository.save(meal, userId);
    }

    @Override
    public void delete(int mealId, int userId) throws NotFoundException {
        boolean result = repository.delete(mealId, userId);
        if(!result) throw new NotFoundException("Meal for id = " + userId +" not found");
        repository.delete(mealId, userId);
    }

    @Override
    public Meal get(int mealId, int userId) throws NotFoundException {
        Meal result = repository.get(mealId, userId);
        if (isNull(result)) throw new NotFoundException("Meal for id = " + userId +" not found");
        return result;
    }

    @Override
    public void update(Meal meal, int userId) {
        Meal result = repository.save(meal, userId);
        if (isNull(result)) throw new NotFoundException("Meal for id = " + userId +" not found");
    }

    @Override
    public List<Meal> getAll(int userId) {
        return repository.getAll(userId);

    }

    @Override
    public List<Meal> getBetween(LocalDateTime start, LocalDateTime end, int userId) {
        return repository.getBetween(start, end, userId);
    }
}