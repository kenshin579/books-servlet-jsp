CREATE TABLE servlet_jsp.users
(
    id varchar(12) PRIMARY KEY NOT NULL,
    passwd varchar (12) NOT NULL,
    addr VARCHAR (50) NOT NULL,
    job varchar (30) NOT NULL,
    salary numeric  NOT NULL,
    name varchar (12) NOT NULL
);

insert into users values('java', 'java', 'address 1', 'software engineer', 10000, 'Frank');