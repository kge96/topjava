package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class InMemoryMealRepository {
    private static final List<Meal> MEALS = Arrays.asList(
            new Meal(LocalDateTime.of(2018, Month.MAY, 30, 10, 0), "Завтрак", 500),
            new Meal(LocalDateTime.of(2018, Month.MAY, 30, 13, 0), "Обед", 1000),
            new Meal(LocalDateTime.of(2018, Month.MAY, 30, 20, 0), "Ужин", 500),
            new Meal(LocalDateTime.of(2018, Month.MAY, 31, 10, 0), "Завтрак", 1000),
            new Meal(LocalDateTime.of(2018, Month.MAY, 31, 13, 0), "Обед", 500),
            new Meal(LocalDateTime.of(2018, Month.MAY, 31, 20, 0), "Ужин", 510)
    );

    public static List<MealWithExceed> getAll(int calories) {
        return MealsUtil.getFilteredWithExceeded(MEALS, LocalTime.MIN, LocalTime.MAX, calories);
    }
}
