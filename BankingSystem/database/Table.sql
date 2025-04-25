create table Aadhar
(
    id int primary key,
    name varchar(20),
    dob DATE 
);

select * from Aadhar;
drop table Aadhar;

---------------------------------------------------------------


create table Users
(
    name varchar(30),
    email varchar(30) references Account(email),
    password varchar(15)
);
select * from Users;
drop table user;
commit;

create table Account
(
    name VARCHAR2(25) not null,
    acc_no number,
    email varchar(30) primary key,
    balance number default 1000
);
select * from Account;
drop table Account;
commit;