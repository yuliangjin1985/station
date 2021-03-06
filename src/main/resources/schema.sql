drop table if exists station;
create table if not exists station
(
   id integer not null AUTO_INCREMENT,
   station_id varchar (255) not null,
   name varchar(255) not null,
   hd_enabled smallint not null,
   call_sign varchar(255),
   primary key(id),
   unique (name),
   unique (hd_enabled)
);
