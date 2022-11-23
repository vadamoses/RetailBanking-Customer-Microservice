drop table if exists customer_table;

create table customer_table (customerid varchar(30) not null, address varchar(255), dateOfBirth date, pan varchar(10), password varchar(255), username varchar(30), primary key (customerid));

insert into customer_table ( customerid, username, password, address, dateOfBirth, pan) values('CUSTOMER101','mark','mark101','Amsterdam','1989-08-03','124');
insert into customer_table ( customerid, username, password, address, dateOfBirth, pan) values('CUSTOMER102','luuk','luuk102','Utrecht','1999-02-04','109');
insert into customer_table ( customerid, username, password, address, dateOfBirth, pan) values('CUSTOMER103','emma','emma103','Helmond','2009-05-05','166');
insert into customer_table ( customerid, username, password, address, dateOfBirth, pan) values('CUSTOMER104','katja','katja104','Eindhoven','2020-09-06','221');