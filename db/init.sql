-- user
create table t_user(
  id int primary key auto_increment,
  name varchar(100) not NULL DEFAULT '' ,
  tel  varchar(50) not null DEFAULT '',
  email varchar(100) not null DEFAULT '',
  password varchar(255) not null DEFAULT '',
  salt varchar(255) not null DEFAULT '',
  create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户表';

-- enterprise
create table t_enterprise(
  id int primary key auto_increment,
  name varchar(100) not NULL DEFAULT '' ,
  address  varchar(500) not null DEFAULT '',
  logo varchar(255) not null DEFAULT '',
  create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '企业表';

-- user_enterprise
create table t_user_enterprise(
  user_id int not null,
  enterprise_id INT NOT NULL ,
  create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (user_id, enterprise_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '用户企业关系表';

-- bank_account
create table t_bank_account(
  id int primary key auto_increment,
  code varchar(50) not NULL DEFAULT '' ,
  user_id INT not null DEFAULT 0,
  amount INT(11) not null DEFAULT 0,
  create_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP,
  update_time TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP on UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT '银行账户表';