# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table task (
  id                        bigint auto_increment not null,
  done                      boolean default false,
  name                      varchar(255),
  description               varchar(255),
  due_to                    datetime,
  created_at                TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  constraint pk_task primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table task;

SET FOREIGN_KEY_CHECKS=1;

