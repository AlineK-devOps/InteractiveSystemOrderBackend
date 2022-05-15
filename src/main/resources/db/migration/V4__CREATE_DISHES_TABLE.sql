CREATE TABLE dishes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    category_id BIGINT NOT NULL,
    name VARCHAR(64) NOT NULL,
    composition VARCHAR(256),
    price INT NOT NULL,
    weight INT NOT NULL,
    image_url VARCHAR(256),
    PRIMARY KEY(id),
    FOREIGN KEY(category_id) REFERENCES dishes_categories(id)
) engine=MyISAM;