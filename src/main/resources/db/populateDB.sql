DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (user_id, calories, description, datetime) VALUES
	(100000, 600, 'Завтрак', '2018-05-30 10:00'),
	(100000, 1500, 'Обед', '2018-05-30 13:00'),
	(100000, 700, 'Ужин', '2018-05-30 20:00'),
	(100000, 500, 'Завтрак', '2018-05-31 10:00'),
	(100000, 900, 'Обед', '2018-05-31 13:00'),
	(100000, 600, 'Ужин', '2018-05-31 20:00');
	