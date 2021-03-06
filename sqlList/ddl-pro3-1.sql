CREATE TABLE guestbook(
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    content text,
    regdate datetime DEFAULT NOW(),
    PRIMARY KEY(id)
);

CREATE TABLE log (
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    ip varchar(255) NOT NULL,
    method varchar(10) NOT NULL,
    regdate datetime DEFAULT NOW(),
    PRIMARY KEY(id)
);

select * from guestbook order by id desc limit 0, 5