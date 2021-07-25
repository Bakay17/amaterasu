create table minibus(
	id serial primary key,
	color varchar not null,
	number_of integer unique not null,
	start_dot varchar not null,
	final_dot varchar not null
);

insert into minibus (id, color, number_of, start_dot, final_dot)
values (1, 'Black', 202, 'Jal', 'Kok-Jar'),
		(2, 'White', 148, 'Asanbai', 'Osh'),
		(3, 'Black', 100, 'Ak-Orgo', 'Bakai-Ata');
select * from minibus 
--------------------------

create table bus(
	id serial primary key,
	color varchar not null,
	number_of integer unique not null,
	start_dot varchar unique not null,
	final_dot varchar unique not null
);
insert into bus (id, color, number_of, start_dot, final_dot)
values (1, 'Yelow', 10, 'Osh', 'Tsum'),
		(2, 'Black', 12, 'Vostok 5', 'Sovetskiy'),
		(3, 'White', 14, 'Jal', 'Dordoi');
select * from bus
-----------------------

create table driver(
	id serial primary key,
	name varchar not null
);
insert into driver (id, name)
values (1, 'Bolot Toretto'),
		(2, 'Dominnik Brat'),
		(3, 'Sanjar Baike');
select * from driver
----------------------------

create table journal(
	id serial primary key,
	driver integer references driver(id) unique not null,
	bus integer references bus(id) not null,
	time_of timestamp not null
);
insert into journal (id, driver, bus, time_of)
values (1, 2, 3, '2020-12-08'),
		(2, 1, 1, '2021-03-29'),
		(3, 3, 2, '2021-06-17');
select * from journal
		
