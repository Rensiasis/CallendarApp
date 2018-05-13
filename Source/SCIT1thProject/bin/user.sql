create table members(
member_seq varchar2(6) primary key,
id varchar2(20) not null,
password varchar2(20) not null,
name varchar2(10),
gender varchar2(1) default 'M',
email varchar2(50),
phone_number varchar2(30),
indate date,
ldate date,
inuser varchar2(10),
luser varchar2(10)
)

create sequence member_seq

create table address(
member_seq varchar2(6),
address_city varchar2(20),
address_country varchar2(20),
address_village varchar2(20),
indate date,
ldate date,
inuser varchar2(10),
luser varchar2(10),

constraint member_fk
foreign key (member_seq)
references members (member_seq)
on delete cascade
)

create table households(
household_seq varchar2(6) primary key, 
member_seq varchar2(6), 
product varchar2(100), 
price number,
count number,
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
member_seq varchar(6),
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
member_seq varchar2(6),
from_date date,
to_date date,
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

select * from MEMBERS
