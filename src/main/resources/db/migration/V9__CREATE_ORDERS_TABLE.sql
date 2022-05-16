CREATE TABLE orders (
    id BIGINT NOT NULL AUTO_INCREMENT,
    table_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(table_id) REFERENCES users(id)
) engine=MyISAM;

INSERT INTO orders VALUES (1, 1);
INSERT INTO orders VALUES (2, 2);