CREATE TABLE users (
  id INT PRIMARY KEY,
  username VARCHAR(256) UNIQUE NOT NULL,
  password VARCHAR(256) NOT NULL,
  enabled smallint NOT NULL
);
 
CREATE TABLE authorities (
  username VARCHAR(256) NOT NULL,
  authority VARCHAR(256) NOT NULL,
  PRIMARY KEY(username, authority)
);