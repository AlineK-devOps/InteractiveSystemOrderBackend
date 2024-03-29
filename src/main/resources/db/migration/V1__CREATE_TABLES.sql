create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    login varchar(64) not null unique,
    password varchar(64) not null,
    name varchar(64) not null,
    PRIMARY KEY (id)
) engine=MyISAM;

CREATE TABLE todo (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title varchar(64) not null,
    completed BOOLEAN NOT NULL,
    PRIMARY KEY (id)
) engine=MyISAM;