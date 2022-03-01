-- member table
create table member(
	num int primary key auto_increment,
	id varchar(20) not null,
	pw varchar(20) not null,
	name varchar(30) not null,
	age int not null,
	email varchar(50) not null,
	tel varchar(30) not null
); 

-- 검색
select * from member;

-- 데이터 삽입 insert
insert into member(id, pw, name, age, email, tel) values('test', '1234', '고길동', 33, 'test@gmail.com', '010-1235-1235');

-- 데이터 수정 update 
update member set age=25, tel='010-1111-1111' where id = 'test';

-- 데이터 삭제 delete
delete from member where id='test';



