-- Table: parent

DROP TABLE IF EXISTS parent;

CREATE TABLE parent
(
  id numeric
);


-- Table: child

DROP TABLE IF EXISTS child;

CREATE TABLE child
(
  id numeric,
  parent_id numeric
);

-- Sequence: hibernate_sequence

DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 4
  CACHE 1
  CYCLE;
