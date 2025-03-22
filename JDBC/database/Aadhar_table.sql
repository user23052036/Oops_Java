create table Aadhar
(
    id int primary key,
    name varchar(20),
    dob DATE 
);

select * from Aadhar;
drop table Aadhar;

---------------------------------------------------------------

create table Account
(
    acc_no number primary key,
    name VARCHAR2(25) not null,
    balance number default 1000
);
select * from Account;
drop table Account;

insert into Account(acc_no,name) values(2036,'Sonu');
insert into Account(acc_no,name) values(2096,'Raki');