--ppt 23페이지
--table 생성 (person): 번호, 이름, 나이, 성별, 지역, 현재날짜
create table person (
    num number(3) PRIMARY key,
    name varchar2(15) not NULL,
    age number(3),
    gender VARCHAR2(10) DEFAULT '남자',
    city varchar2(15) DEFAULT '서울',
    today DATE
);

--데이터 조회
select * from person;

-- insert
insert into person(num,name,today) VALUES (1,'SexyHong',sysdate);

--pk(primary key), nn(not null) 이 경우 값을 안넣어주면 오류발생-확인
insert into person(name, age, today) VALUES ('김철수',23,'2022-09-18');

--nn속성이 들어간 컬럼은 무조건넣어줘야한다,이번에는 num에 같은데이터 넣어보기
insert into person(num,name, age, today) VALUES (1,'김철수',23,'2022-09-18');

--오류없이 나오도록 제데로 넣어보자
insert into person(num,name, age, today) VALUES (2,'김철수',23,'2022-09-18');

--일부 컬럼이 아니라 순서대로 모든 컬럼값을 넣을경우 컬럼명 생략가능
insert into person VALUES (3,'김첨지',52,'여자','강남','1895-05-12');
--각각 7개정도 추가 해보자
insert into person VALUES (4,'고고고',2,'여자','강남','1895-05-12');
insert into person VALUES (5,'이이이',5,'남자','강북','2023-06-12');
insert into person VALUES (6,'어이김',36,'여자','성남','2012-11-19');
insert into person VALUES (7,'아이구',25,'남자','강서','2011-12-17');
insert into person VALUES (8,'요리사',89,'여자','인천','1999-01-13');
insert into person VALUES (9,'반가워',15,'남자','울산','2002-09-17');
insert into person VALUES (10,'바나나',29,'여자','광주','2014-04-28');
commit;

--박지나의 age, city 수정
update person set age=26, city='제주도' where name='바나나';
--홍길동의 나이 수정
update person set age=87 where name='SexyHong';
--이진의 today를 현재날짜로 수정
update person set today=sysdate where name='어이김';
commit;
--delete : where 조건을 안쓰면 전체 모두 삭제됨
delete from person;

--다시 살리기
rollback; --마지막 커밋 이후 까지만 롤백
--조건을 이용해서 삭제
delete from person where name='고고고';

--나이가 30세 미만인경우 모두 삭제
delete from person where age <= 30;
rollback;

--지금부터는 테이블 구조를 수정하는 연습
--테이블에 컬럼추가
ALTER table person add score number(3) default(50);

--추가한 socre 컬럼을 제거
ALTER table person drop column score;

--컬럼 타입 수정
alter table person modify city varchar2(20);

--컴럼명 변경 today->ipsaday 로 변경
alter table person rename column today to ipsaday;

--제약조건을 제거 : name 에 not null 제약조건이 들어있다(제약조건이름울 안줘서 기본으로 이름이 들어가 있다)
--SYS_C008317
alter table person drop CONSTRAINT SYS_C008320;

--name 에 새로운 조건을 추가해보자(UNIQUE)
alter table person ADD CONSTRAINT PERSON_UQ_NAME UNIQUE(NAME);

--이름에 같은 이름을 너흥면 이제오류가 발생
--ORA00001: 무결성 제약조건 (ANGEL.PERSON_UQ_NAME에 위배됩니다;
insert into person (num,name) VALUES(50,'SexyHong'); --오류

 --gender 에 '남자','여자'의 이외의 데이터를 넣으면 오류가 발생하게
 alter table person ADD CONSTRAINT person_CK_GENDER CHECK(GENDER IN('남자','여자'));
 
 --AGE에 2 ~ 100 세만 추가 가능하도록 제약조건을 추가해보자
 alter table person ADD CONSTRAINT person_CK_AGE check(AGE >=2 AND AGE <= 100);
 
 --제약조건에 위배되도록 나이를 추가해보자
insert into person (num,name,AGE) VALUES(100,'SexyHong',900);

--문제
--PK제약 조건을 제거후 PERSON_PX_NUM 이라는 새로운 제약조건을 추가해보자
--SYS_C008321 제거
alter table person drop CONSTRAINT  SYS_C008321;
alter table person ADD CONSTRAINT PERSON_PX_NUM PRIMARY key (num);

--문제
--BUSEO 라는 컬럼을 추가 VARCHAR2(10) 기본박을 '교육부'
alter table person add BUSEO VARCHAR2(10) default('교육부');
--BUSEO 에 제약조건 추가 '교육부','홍보부','인사부' 3개만 추가가 가능하도록
alter table person ADD CONSTRAINT person_CK_BUSEO check(BUSEO in('교육부','홍보부','인사부'));
insert into person VALUES (10,'바나나',29,'여자','광주','2014-04-28','야랄부');

--문제 김씨 와 바씨성을 가진 사람은 모두 '인사부' 로 데이터 수정
update person set BUSEO='인사부' where name LIKE '김%' or name LIKE '바%';

-- 이씨 어씨 아씨 성을 사진 사람들은 모두 '홍보부' 로 수정
update person set BUSEO='홍보부' where name like '이%' or name like '어%' or name like'아%';

--문제
--남자 여자 평균 나이 (정수) 구하기 - 인원수가 많은것 부터 출력
alter table person add avg number(3,0);

select ceil(avg(age)) as 남자 from person where GENDER = '남자';
select ceil(avg(age)) 여자 from person where GENDER = '여자';

-- 인원수(2) 내림 차순 정렬
select gender 성별, count(*) 인원수, ceil(avg(age)) 평균나이 from person group by gender order by 2 desc;

--부서별(1)로 인원수와 평균 나이 구하기 - 부서명의 오름차순 출력
select buseo 부서명, count(*) 인원수, ceil(avg(age)) 평균나이 from person group by buseo order by 1;

--시퀀스 생성하는 방법 ppt 78 페이지
--가장 많이 사용하는 기본 시퀀스 : 1부터 1씩 증가하는 시퀀스
create SEQUENCE seq1;
create SEQUENCE seq2 start with 10 increment by 10; --10에서부터 10씩 증가
create SEQUENCE seq3 start with 10 increment by 5 nocache; --nocache : cache를 0으로
create SEQUENCE seq4 MAXVALUE 100; --max 값이 100까지만 발생
--시퀀스 조회
select * from seq;
--테이블 조회
select * from tab;
--시퀀스 제거
drop SEQUENCE seq2;
drop SEQUENCE seq4;

--다음값 발생 nextval, 현재값  currval
select seq1.nextval,seq3.nextval from dual; --반복해서 실행해본다

select seq1.currval,seq3.currval from dual; --마지막 발생한 값
commit;