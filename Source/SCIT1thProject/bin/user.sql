
--ȸ�� ���� ���̺�
create table userinfo (
	id 			varchar2(20) 	primary key,	--ȸ�� ID
	name 		varchar2(20) 	not null,  		--�ۼ��� �̸�
	gender 		char(1) 		default 'M' 	--����
);

-- ȸ������ �ּ� ���� ���̺�
create table useraddr (
	id			varchar2(20) unique, 		--ȸ�� ID
	phone		varchar2(50) not null, 		--��ȭ��ȣ
	address		varchar2(100) not null,  	--�ּ�
	constraint useraddr_fk foreign key(id) 
	references userinfo(id) on delete cascade
);

-- ���� ������
insert into userinfo values ('aaa', 'ȫ�浿', 'M');
insert into userinfo values ('bbb', '��ö��', 'M');
insert into userinfo values ('ccc', '�̿���', 'F');
insert into useraddr values ('aaa', '010-1111-1111', '����� ������ �Ｚ�� 1');
insert into useraddr values ('bbb', '010-2222-2222', '��⵵ ���� �ϻ굿�� �鼮�� 1');

-- Outer Join (useraddr �ʿ� �����Ͱ� ��� ����� ��������)
select
    i.id, i.name, i.gender, a.phone, a.address
from userinfo i, useraddr a 
where i.id = a.id(+);

