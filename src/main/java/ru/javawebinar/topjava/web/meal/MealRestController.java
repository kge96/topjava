package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
public class MealRestController {
    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

    private MealService service;

    @Autowired
    public MealRestController(MealService service) {
        this.service = service;
    }

    public Meal create(Meal meal) {
        int userId = SecurityUtil.authUserId();
        log.info("create {} for user {}", meal, userId);
        return service.create(meal, userId);
    }

    public void update(Meal meal, int id) {
        int userId = SecurityUtil.authUserId();
        log.info("update {} for user", meal, userId);
        service.update(meal, userId);
    }

    public void delete(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("delete meal {} for user {}", id, userId);
        service.delete(id, userId);
    }

    public Meal get(int id) {
        int userId = SecurityUtil.authUserId();
        log.info("get meal {} for user {}", id, userId);
        return service.get(id, userId);
    }

    public List<MealWithExceed> getAll() {
        int userId = SecurityUtil.authUserId();
        log.info("get all meals for user {}", userId);
        return MealsUtil.getWithExceeded(service.getAll(userId), SecurityUtil.authUserCaloriesPerDay());
    }

    public List<MealWithExceed> getBeetween(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        int userId = SecurityUtil.authUserId();
        log.info("getBetween datet {} - {} time {} - {} for user {}", startDate, endDate, startTime, endTime, userId);
        LocalDate startD = startDate == null ? LocalDate.MAX : startDate;
        LocalDate endD = endDate == null ? LocalDate.MIN : endDate;
        LocalTime startT = startTime == null ? LocalTime.MAX : startTime;
        LocalTime endT = endTime == null ? LocalTime.MIN : endTime;

        return MealsUtil.getWithExceeded(service.getBetween(LocalDateTime.of(startD, startT), LocalDateTime.of(endD, endT), userId), SecurityUtil.authUserCaloriesPerDay());
     }
}