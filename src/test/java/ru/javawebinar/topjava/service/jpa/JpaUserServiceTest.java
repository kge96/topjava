package ru.javawebinar.topjava.service.jpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.UserServiceTest;

import static ru.javawebinar.topjava.Profiles.HSQL_DB;
import static ru.javawebinar.topjava.Profiles.JPA;

@ActiveProfiles({HSQL_DB, JPA})
public class JpaUserServiceTest extends UserServiceTest {
}
