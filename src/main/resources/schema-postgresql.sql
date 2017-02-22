-- Table: parent

DROP TABLE IF EXISTS parent;

CREATE TABLE parent
(
  id numeric
)
WITH (
  OIDS=FALSE
);
ALTER TABLE parent
  OWNER TO postgres;


-- Table: child

DROP TABLE IF EXISTS child;

CREATE TABLE child
(
  id numeric,
  parent_id numeric
)
WITH (
  OIDS=FALSE
);
ALTER TABLE child
  OWNER TO postgres;

-- Sequence: hibernate_sequence

DROP SEQUENCE IF EXISTS hibernate_sequence;

CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 4
  CACHE 1
  CYCLE;
ALTER TABLE hibernate_sequence
  OWNER TO postgres;
