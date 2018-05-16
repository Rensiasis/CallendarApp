create table members(
member_seq varchar2(6) primary key,
id varchar2(20) not null,
password varchar2(20) not null,
name varchar2(10),
gender varchar2(1) default 'M',
email varchar2(50),
phone_number varchar2(30),
postNumber varchar2(30),
newAddress varchar2(1000),
city varchar2(30),
county varchar2(30),
village varchar2(30),
indate date,
ldate date,
inuser varchar2(10),
luser varchar2(10)
)

create sequence member_seq

create table households(
household_seq varchar2(6) primary key, 
member_seq varchar2(6), 
product varchar2(100), 
price number,
get_date date,
content varchar2(500),
indate date,
ldate date,
inuser varchar2(10),
luser varchar2(10),

constraint house_member_fk
foreign key (member_seq)
references members (member_seq)
on delete cascade
)

create sequence household_seq

create table accounts(
member_seq varchar(6) primary key,
account number,
montly_salary number,
montly_save number,
indate date,
ldate date,
inuser varchar2(10),
luser varchar2(10),

constraint account_member_fk
foreign key (member_seq)
references members (member_seq)
on delete cascade
)

create table schedule(
schedule_seq varchar2(6),
member_seq varchar2(6),
data_type varchar2(10),
from_date date,
to_date date,
time varchar2(30),
content varchar2(500),
indate date,
ldate date,
inuser varchar2(10),
luser varchar2(10),

constraint sch_member_fk
foreign key (member_seq)
references members (member_seq)
on delete cascade
)

create sequence schedule_seq

drop table schedule

select sum(price) from households where member_seq='1';



select account from ACCOUNTS 
where member_seq='1'; 

select * from members;
select * from households
select * from accounts

insert into HOUSEHOLDS (household_seq, member_seq, product, price, get_date, content) 
values (household_seq.nextval, '1', '1년전사과', 500, to_date('17/06/16', 'YY/MM/DD'), '실험용세팅1');
insert into HOUSEHOLDS (household_seq, member_seq, product, price, get_date, content) 
values (household_seq.nextval, '1', '6개월전사과', 800, to_date('18/01/01', 'YY/MM/DD'), '실험용세팅1');
insert into HOUSEHOLDS (household_seq, member_seq, product, price, get_date, content) 
values (household_seq.nextval, '1', '3개월전사과', 1000, to_date('18/03/16', 'YY/MM/DD'), '실험용세팅3');