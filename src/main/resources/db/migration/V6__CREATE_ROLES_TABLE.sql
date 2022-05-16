CREATE TABLE roles (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(64) not null,
    PRIMARY KEY (id)
) engine=MyISAM;

INSERT INTO roles VALUES (1, "CUSTOMER");
INSERT INTO roles VALUES (2, "WAITER");
INSERT INTO roles VALUES (3, "COOK");