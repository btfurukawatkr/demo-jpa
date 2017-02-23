-- Table: parent

DROP TABLE IF EXISTS parent;

CREATE TABLE parent
(
  id int auto_increment,
  index(id)
);


-- Table: child

DROP TABLE IF EXISTS child;

CREATE TABLE child
(
  id int auto_increment,
  parent_id int,
  index(id)
);

