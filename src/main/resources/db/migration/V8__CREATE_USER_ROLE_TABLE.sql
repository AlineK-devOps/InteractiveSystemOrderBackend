CREATE TABLE user_role (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(role_id) REFERENCES roles(id)
) engine=MyISAM;

INSERT INTO user_role VALUES (1, 1, 1);
INSERT INTO user_role VALUES (2, 2, 1);
INSERT INTO user_role VALUES (3, 3, 1);
INSERT INTO user_role VALUES (4, 4, 2);
INSERT INTO user_role VALUES (5, 5, 2);
INSERT INTO user_role VALUES (6, 6, 3);
INSERT INTO user_role VALUES (7, 7, 3);
INSERT INTO user_role VALUES (8, 8, 3);