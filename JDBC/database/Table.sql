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
commit;

insert into Account(acc_no,name) values(2036,'Sonu');
insert into Account(acc_no,name) values(2096,'Raki');
insert into Account(acc_no,name,balance) values(1994,'Kritwik',5000);
insert into Account(acc_no,name,balance) values(1992,'Romoi',10000);
insert into Account(acc_no,name,balance) values(1980,'Sabita',5250);
insert into Account(acc_no,name,balance) values(1191,'Mousami Das',500);
insert into Account(acc_no,name,balance) values(1094,'Rohini Singh',700);