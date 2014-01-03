drop table dog;
create table dog(
	id number,
	name varchar2(12),
	price number,
	image varchar2(20),
	country varchar2(12),
	height number,
	weight number,
	des varchar2(400),
	click number
);

add constraint pk_dog primary key(id);

insert into dog values(1, 'Ǫ��', 10000, 'pu.jpg', 
'������', 1, 20, '���� �� ǰ��, ������ �����̸� �ֿϿ����� ���� �⸥��. ���������� ������ ���� �������� �����Ͽ� ������ ���� �������', 0);
insert into dog values(2, 'ǳ�갳', 20000, 'pung.jpg', 
'�ѱ�', 2, 10, '���� �� ǰ��, ������ �����̸� �ֿϿ����� ���� �⸥��. ���������� ������ ���� �������� �����Ͽ� ������ ���� �������', 0);
insert into dog values(3, '������', 30000, 'jin.jpg', 
'�ѱ�', 3, 50, '���� �� ǰ��, ������ �����̸� �ֿϿ����� ���� �⸥��. ���������� ������ ���� �������� �����Ͽ� ������ ���� �������', 0);
insert into dog values(4, '��찳', 40000, 'sap.jpg', 
'�ѱ�', 2, 20, '���� �� ǰ��, ������ �����̸� �ֿϿ����� ���� �⸥��. ���������� ������ ���� �������� �����Ͽ� ������ ���� �������', 0);
commit

UPDATE dog SET click=click+1 WHERE name='Ǫ��';

CREATE SEQUENCE dog_seq START WITH 1 NOCACHE;

select * from dog 

insert into member values('sunny', 'aaaa');