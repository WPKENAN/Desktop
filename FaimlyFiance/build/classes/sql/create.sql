use tsjy;

create table record_type(
  id int auto_increment primary key,
  type varchar(10),
  name varchar(200) 
);
create table budget(
  id int auto_increment primary key,
  name int,
  sum double,
  bdate date
);
create table account_type(
  id int auto_increment primary key,
  name varchar(200) ,
  balance double ,
  remark varchar(200) 
);
create table member(
  id int auto_increment primary key,
  sex varchar(10),
  name varchar(20) 
)character set =utf8 ;
create table record(
  id int auto_increment primary key,
  type varchar(10) ,
  record_type varchar(10),
  account_type varchar(10),
  member varchar(10),
  remark varchar(200),
  sum double,
  rdate varchar(20)
);


