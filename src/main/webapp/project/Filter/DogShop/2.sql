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

insert into dog values(1, '푸들', 10000, 'pu.jpg', 
'프랑스', 1, 20, '개의 한 품종, 프랑스 원산이며 애완용으로 많이 기른다. 프랑스에서 개량된 것을 영국에서 수입하여 유일한 개로 만들었다', 0);
insert into dog values(2, '풍산개', 20000, 'pung.jpg', 
'한국', 2, 10, '개의 한 품종, 프랑스 원산이며 애완용으로 많이 기른다. 프랑스에서 개량된 것을 영국에서 수입하여 유일한 개로 만들었다', 0);
insert into dog values(3, '진도개', 30000, 'jin.jpg', 
'한국', 3, 50, '개의 한 품종, 프랑스 원산이며 애완용으로 많이 기른다. 프랑스에서 개량된 것을 영국에서 수입하여 유일한 개로 만들었다', 0);
insert into dog values(4, '삽살개', 40000, 'sap.jpg', 
'한국', 2, 20, '개의 한 품종, 프랑스 원산이며 애완용으로 많이 기른다. 프랑스에서 개량된 것을 영국에서 수입하여 유일한 개로 만들었다', 0);
commit

UPDATE dog SET click=click+1 WHERE name='푸들';

CREATE SEQUENCE dog_seq START WITH 1 NOCACHE;

select * from dog 

insert into member values('sunny', 'aaaa');