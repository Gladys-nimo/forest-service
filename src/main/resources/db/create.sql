SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS animals(
  id int PRIMARY KEY auto_increment,
  description VARCHAR,
  completed BOOLEAN
);
