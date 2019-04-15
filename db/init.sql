-- user
create table user(
  id int primary key auto_increment,
  name varchar(100) not NULL DEFAULT '' ,
  tel  varchar(50) not null DEFAULT '',
  email varchar(100) not null DEFAULT '',
  password varchar(255) not null DEFAULT '',
  salt varchar(255) not null DEFAULT '',
  create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP,
  update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP
);