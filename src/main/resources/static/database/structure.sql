USE bikeRentDB;

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  role_id INT(10) NOT NULL AUTO_INCREMENT,
  role    VARCHAR(255)     DEFAULT NULL,
  PRIMARY KEY (role_id)
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8;

INSERT INTO role VALUES (1, 'ADMIN');

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  user_id        INT(10)      NOT NULL AUTO_INCREMENT,
  userName       VARCHAR(255) NOT NULL,
  userLastName VARCHAR(255) NOT NULL,
  email        VARCHAR(255) NOT NULL,
  password     VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
)
  ENGINE = MyISAM
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  user_id INT(10) NOT NULL,
  role_id INT(10) NOT NULL,
  PRIMARY KEY (user_id, role_id),
  KEY FKa68196081fvovjhkek5m97n3y (role_id),
  CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES user (user_id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES role (role_id)
)
  ENGINE = MyISAM
  DEFAULT CHARSET = utf8;



