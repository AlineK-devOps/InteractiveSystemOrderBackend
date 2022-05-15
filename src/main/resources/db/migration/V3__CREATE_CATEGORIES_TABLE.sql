CREATE TABLE dishes_categories (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(64) not null,
    PRIMARY KEY (id)
) engine=MyISAM;

INSERT INTO dishes_categories VALUES (1, "SUSHI");
INSERT INTO dishes_categories VALUES (2, "ROLL");
INSERT INTO dishes_categories VALUES (3, "HOT_ROLL");
INSERT INTO dishes_categories VALUES (4, "SNACK");
INSERT INTO dishes_categories VALUES (5, "WOK");
INSERT INTO dishes_categories VALUES (6, "SOUP");
INSERT INTO dishes_categories VALUES (7, "DRINK");
INSERT INTO dishes_categories VALUES (8, "ADDITIONALLY");