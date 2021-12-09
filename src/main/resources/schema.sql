--================================================== User
DROP TABLE IF EXISTS tbl_user;
CREATE TABLE tbl_user (
     id uuid CONSTRAINT pk_user_id PRIMARY KEY,
     name varchar(50) NOT NULL
);

--================================================== Destiny
DROP TABLE IF EXISTS tbl_destiny;
CREATE TABLE tbl_destiny (
 id uuid CONSTRAINT pk_destiny_id PRIMARY KEY,
 name varchar(50) NOT NULL,
 value NUMERIC NOT NULL,
 state varchar(2) NOT NULL,
 description varchar(100)
);

--================================================== Provider
DROP TABLE IF EXISTS tbl_provider;
CREATE TABLE tbl_provider (
     id uuid CONSTRAINT pk_provider_id PRIMARY KEY,
     name varchar(50) NOT NULL
);

--================================================== Travel

DROP TABLE IF EXISTS tbl_travel;
CREATE TABLE tbl_travel(
 id uuid CONSTRAINT pk_travel_id PRIMARY KEY,
 datetime TIMESTAMP NOT NULL,
 qtd integer NOT NULL,
 user_id uuid NOT NULL,
 destiny_id uuid NOT NULL,
 provider_id uuid NOT NULL
);

ALTER TABLE tbl_travel ADD CONSTRAINT fk_travel_user FOREIGN KEY(user_id) REFERENCES tbl_user(id);
ALTER TABLE tbl_travel ADD CONSTRAINT fk_travel_des FOREIGN KEY(destiny_id) REFERENCES tbl_destiny(id);
ALTER TABLE tbl_travel ADD CONSTRAINT fk_trans_provider FOREIGN KEY(provider_id) REFERENCES tbl_provider(id);