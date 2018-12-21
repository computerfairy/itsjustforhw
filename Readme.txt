//일정 관리 메뉴에 필요한 DB
CREATE TABLE MyAppointments(
	aid VARCHAR(11),
	acontent VARCHAR(100),
	adate DATE,
	alocation VARCHAR(100),
	apersons VARCHAR(100),
	primary key(aid) );

//JUNIT 테스트를 수행하기 위해서는 적어도 1개 이상의 데이터가 필요합니다.
-테스트용 데이터
insert into MyAppointments values('201812211','c1','18/12/21','l1','p1');