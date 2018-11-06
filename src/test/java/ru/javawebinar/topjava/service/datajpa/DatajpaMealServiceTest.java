package ru.javawebinar.topjava.service.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.ActiveDbProfileResolver;
import ru.javawebinar.topjava.service.MealServiceTest;

@ActiveProfiles(resolver = ActiveDbProfileResolver.class)
public class DatajpaMealServiceTest extends MealServiceTest {
}
