CREATE TABLE CATEGORY(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  when_created datetime NOT NULL DEFAULT current_timestamp,
  when_last_updated datetime NOT NULL DEFAULT current_timestamp,
  name VARCHAR(64) NOT NULL UNIQUE,
  description VARCHAR(128) NOT NULL
  );
  

CREATE TABLE ITEM(
  id INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
  when_created datetime NOT NULL DEFAULT current_timestamp,
  when_last_updated datetime NOT NULL DEFAULT current_timestamp,
  description VARCHAR(128) NOT NULL UNIQUE,
  due_date datetime NOT NULL DEFAULT current_timestamp,
  finished BOOLEAN NOT NULL DEFAULT FALSE,
  category_id INTEGER REFERENCES category(id)
  );