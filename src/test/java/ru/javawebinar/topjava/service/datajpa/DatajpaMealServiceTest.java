package ru.javawebinar.topjava.service.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.MealServiceTest;

import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.HSQL_DB;


@ActiveProfiles({HSQL_DB, DATAJPA})
public class DatajpaMealServiceTest extends MealServiceTest {
}
