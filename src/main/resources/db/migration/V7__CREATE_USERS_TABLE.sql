CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(32) NOT NULL,
    password VARCHAR(64) NOT NULL,
    name VARCHAR(64) NOT NULL,
    PRIMARY KEY(id)
) engine=MyISAM;

INSERT INTO users VALUES (1, "customer_1", "cus1table", "Столик №1");
INSERT INTO users VALUES (2, "customer_2", "cus2table", "Столик №2");
INSERT INTO users VALUES (3, "customer_3", "cus3table", "Столик №3");
INSERT INTO users VALUES (4, "waiter_1", "wait1personal", "Артемов В.В.");
INSERT INTO users VALUES (5, "waiter_2", "wait2personal", "Кривоусов С.А.");
INSERT INTO users VALUES (6, "cook_1", "cook1personal", "Степанов С.А.");
INSERT INTO users VALUES (7, "cook_2", "cook2personal", "Васильков А.А.");
INSERT INTO users VALUES (8, "cook_3", "cook3personal", "Рудина С.В.");