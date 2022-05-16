CREATE TABLE statuses (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(32) NOT NULL,
    PRIMARY KEY(id)
) engine=MyISAM;

INSERT INTO statuses VALUES (1, "IN_QUEUE_FOR_COOKING");
INSERT INTO statuses VALUES (2, "IN_COOKING_PROCESS");
INSERT INTO statuses VALUES (3, "IN_QUEUE_FOR_SERVING");
INSERT INTO statuses VALUES (4, "SERVED");

CREATE TABLE order_list (
    id BIGINT NOT NULL AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    dish_id BIGINT NOT NULL,
    cook_id BIGINT,
    waiter_id BIGINT,
    status_id BIGINT NOT NULL DEFAULT 1,
    PRIMARY KEY(id),
    FOREIGN KEY(order_id) REFERENCES orders(id),
    FOREIGN KEY(dish_id) REFERENCES dishes(id),
    FOREIGN KEY(cook_id) REFERENCES users(id),
    FOREIGN KEY(waiter_id) REFERENCES users(id),
    FOREIGN KEY(status_id) REFERENCES statuses(id)
) engine=MyISAM;

INSERT INTO order_list VALUES (1, 1, 5, NULL, NULL, 1);
INSERT INTO order_list VALUES (2, 1, 2, NULL, NULL, 1);
INSERT INTO order_list VALUES (3, 2, 10, NULL, NULL, 1);