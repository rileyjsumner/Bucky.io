CREATE DATABASE IF NOT EXISTS buckyio;
USE buckyio;
DROP TABLE IF EXISTS usersTest;
CREATE TABLE IF NOT EXISTS usersTest (
  userid INT NOT NULL auto_increment,
  username VARCHAR(50),
  password TEXT,

  PRIMARY KEY(userid)
);