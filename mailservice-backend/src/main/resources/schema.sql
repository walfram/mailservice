-- drop table if exists messages;

create table messages (
id int auto_increment primary key,
address varchar(255) not null,
subject varchar(255) not null,
message varchar(4096) not null,
int sent not null default 0
);