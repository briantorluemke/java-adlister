# mysql -u main -p

USE adlister_db;

CREATE TABLE users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(128),
  email VARCHAR(128),
  password VARCHAR(128),
  PRIMARY KEY (id)
);

CREATE TABLE ads (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED DEFAULT NULL,
  title VARCHAR(128),
  description TEXT,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);