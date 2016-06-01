
drop table hotel;

drop table role

create table hotel (
	id bigint NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name varchar(100),
	stars integer,
	price decimal
);

create table permission (
	id bigint NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	permission varchar(50) not null
);

create table role (
	id bigint NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	role varchar(50) not null
);

create table user_role (
	role_id_fk bigint not null,
	user_id_fk bigint not null
)

create table user_permission (
	permission_id_fk bigint not null,
	user_id_fk bigint not null
)



insert into hotel (name, stars, price) values ('Motel 100',5,100);

insert into role ( role ) values ('user');
insert into role ( role ) values ('admin');

insert into permission ( permission ) values ('report:view');
insert into user_permission  values (1,5)


select * from hotel
select * from user_permission

select * from user_role
delete from user_role where user_id_fk = 3

select * from booking
select * from person
delete from person where id = 3;



