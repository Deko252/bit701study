-- sawon 에 제약조건 추가하기
-- score 는 0~100 만 추가 가능하도록 제약조건 추가
alter table sawon add constraint sawon_ck_score check (score between 0 and 100);

-- gender 에 '남자' '여자' 만 가능하도록 check 제약조건 추가
alter table sawon add constraint sawon_ck_score check (gender in( '남자','여자'));

-- mysql 에서 제약조건 확인
select * from information_schema.table_constraints where table_name = 'sawon';

-- 데이터 추가
insert into sawon values(null, '김첨지', 78, '남자', '설렁탕');
insert into sawon values(null, '박말순', 95, '여자', '감자');
insert into sawon (name, score, gender) values('요로로', 82, '여자');
insert into sawon values(null, '소년', 87, '남자', '영업부');
insert into sawon values(null, '김정은', 42, '남자', '로동당');
insert into sawon values(null, '김일성', 58, '남자', '로동당');
insert into sawon values(null, '김정일', 95, '남자', '로동당');
insert into sawon values(null, '이말순', 100, '여자', '감자');
insert into sawon values(null, '박천지', 75, '남자', '설렁탕');
insert into sawon (name, score, gender) values('유루루', 12, '여자');
insert into sawon values(null, '청소년', 50, '남자', '영업부');

-- 쿼리문 연습하기
-- 김씨 성을 가진 사람의 인원수 구하기
select count(*) from sawon where name like '김%';
-- 평균 점수보다 높은사람 출력하기
select * from sawon where score > (select avg(score) from sawon);
-- 부서별 인원수와 평균점수 최고점수 최저점수 구하기(제목도수정)
select buseo 부서명, count(*) 인원수, avg(score) 평균점수, max(score) 최고점수,
min(score) 촤저점수 from sawon group by buseo;
-- 인사부에서 박씨성을 가진 사람이 누가 있는지 출력
select * from sawon where buseo = '로동당' and name like '박%';
-- 박말순의 부서를 로동당으로 수정
update sawon set buseo='로동당' where name='박말순';

-- join 연습할 서브 테이블 생성 sawoninfo idx,num(외부키),addr,hp,age 컬람 - 부모테이블 데이터 삭제시 서브테이블 데이터 자동 삭제하려면 제약조건 뒤에 on delete cascade 추가

create table sawoninfo(
	idx smallint auto_increment primary key,
    num smallint,
    addr varchar(30),
    hp varchar(20),
    age smallint,
    constraint info_fk_num foreign key(num) references sawon(num)
);
-- 제약조건도 확인
select * from information_schema.table_constraints where table_name = 'sawoninfo';

-- sawoninfo에 데이터 추가 ( 반드시 sawon의 num 에 있는 값만 넣을수있다)
insert into sawoninfo values(null, 1 , '전주', '010-1111-1111', 65);
insert into sawoninfo values(null, 2 , '서울', '010-2222-2222', 52);
insert into sawoninfo values(null, 3 , '대구', '010-3333-3333', 78);
insert into sawoninfo values(null, 4 , '부산', '010-4444-4444', 30);
insert into sawoninfo values(null, 5 , '평양', '010-5555-5555', 13);
insert into sawoninfo values(null, 6 , '광주', '010-6666-6666', 13);
insert into sawoninfo values(null, 7 , '인천', '010-7777-7777', 13);
insert into sawoninfo values(null, 8 , '개성', '010-8888-8888', 13);
insert into sawoninfo values(null, 9 , '제주', '010-9999-9999', 13);
insert into sawoninfo values(null, 10 , '신의주', '010-1010-1010', 13);
insert into sawoninfo values(null, 11 , '울산', '010-1101-1101', 13);

-- sawoninfo 만 데이터 확인
select * from sawoninfo;

-- sawon 테이블과 join으로 사원 정보 모두 출력하기
-- join 방법 1
select
	s.num,name,gender,buseo,age,hp,addr,score
from sawon s, sawoninfo si
where s.num = si.num;

-- join 방법2
select
	sawon.num,name,gender,buseo,age,hp,addr,score
from sawon
inner join sawoninfo on sawon.num = sawoninfo.num;

-- on delete cascade : sawon 에서 2번 데이터 삭제시 sawoninfo 에서도 삭제됨
-- 문제 기준 외부키 제약조건 제거하고 다시 ( on delete cascade 추가);

drop table sawoninfo;
alter table sawoninfo drop constraint info_fk_num;
alter table sawoninfo add constraint info_fk_num foreign key(num) references sawon(num) on delete cascade;

delete from sawon where num = 2;

select
	s.num,name,gender,buseo,age,hp,addr,score
from sawon s, sawoninfo si
where s.num = si.num;

-- mysql 함수들 연습
select now() from dual; -- 현재 날짜와 시간

select year(now()) from dual; -- 2023 년도만 추출
select month(now()) from dual; -- 월만 추출 3
select monthname(now()) from dual; -- 월을 영어로
select dayname(now()) from dual; -- 요일을 영어로
select dayofmonth(now()) from dual; -- 일

-- 문자 함수
select concat('Happy','Day','!!') from dual; -- concat 문자열 니열(갯수 상관없음)
select replace('Hallo','e','*') from dual; -- 대치,변경
select instr('Happy Day','Day') from dual; -- 7 위치 찾기
select left('bitcamp 701 class',7) from dual; -- 왼쪽에서 7글자 추출
select right('bitcamp 701 class',9) from dual; -- 오른쪽에서 9 글자 추출
select mid('bitcamp 701 class',9,3) from dual; -- 9번쨰부터 3글자 추출
select substring('bitcamp 701 class',9,3) from dual; -- 9번쨰부터 3글자 추출
select concat('*',trim('  hello  '), '*') from dual; -- 양쪽 공백 제거
select concat('*',ltrim('  hello  '), '*') from dual; -- 왼쪽 공백 제거
select concat('*',rtrim('  hello  '), '*') from dual; -- 오른쪽 공백 제거
select ucase('Happy'),upper('Happy') from dual; -- 두개 다 대문자 변환
select lcase('Happy'),lpper('Happy') from dual; -- 두개 다 소문자 변환
select reverse('Happy') from dual; -- 거꾸로 출력alter

-- 숫자함수
select ceiling(7.1), ceil(7.1) from dual; -- 무조건 올림
select floor(7.1) from dual; -- 무조건 내림
select round(7.47,1) from dual; -- 반올림
select round(7.41,1) from dual; -- 반올림
select mod(7,2) from dual; -- 나머지
select greatest(12, 35, 95, 100, 5) from dual; -- 가장 큰값
select least(12, 35, 95, 100, 5) from dual; -- 가장 작은값

select count(*) cnt from sawon, sawoninfo where sawon.num = sawoninfo.num;
select buseo, count(*) count, round(avg(score),1) avgscore, max(score) maxscore,
min(score) minscore from sawon group by buseo;