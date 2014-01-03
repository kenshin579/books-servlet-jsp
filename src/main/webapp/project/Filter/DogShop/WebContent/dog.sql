DROP TABLE dog purge;
create table dog(
	id number primary key,
	kind varchar2(12),
	price number,
	image varchar2(20),
	country varchar2(12),
	height number,
	weight number,
	content varchar2(400),
		readcount number );

//�ߺ������ʴ� ���� �ڵ����� ���� �ϱ� ����

create sequence dog_se start with 1 nocache;

insert into dog values(1, 'Ǫ��','10000','pu','������','1','20','Ǫ��Ǫ�� �Ϳ�����',0);
insert into dog values(2, 'ǳ�갳','20000','pung','�ѱ�','2','10','ǳ��ǳ�� �Ϳ�����',0);
insert into dog values(3, '������','30000','jin','�ѱ�','3','50','�������� �Ϳ�����',0);
insert into dog values(4, '��찳','40000','sap','�ѱ�','2','20','����� �Ϳ�����',0);

commit