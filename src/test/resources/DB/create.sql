SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  description VARCHAR,
  news_id int
  users_id int
);


CREATE TABLE IF NOT EXISTS users (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  position VARCHAR,
  role VARCHAR,
  department_id int
);

CREATE TABLE IF NOT EXISTS news (
  id int PRIMARY KEY auto_increment,
  general VARCHAR,
  departmental VARCHAR,
  role VARCHAR,
  department_id int
);