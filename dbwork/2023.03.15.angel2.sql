--문제
--태이블 생성 (student) : num  숫자(5) , name 문자열(10), height 숫자(5,1),
--java 숫자(3) 기본값 10, spring 숫자(3) 기본값(10), ban 문자열(20)
create table student (
     num number(5),
     name varchar2(10),
     height number(5,1),
     java number(3) DEFAULT(10),
     spring number(3) DEFAULT(10),
     ban varchar2(20)
);

select * from student;

--시퀀스 생성 seq_stu 기본(1부터 1씩증가), nocache 추가
create SEQUENCE seq_stu nocache;
select * from seq;
--제약조건들 추가
--num 에 primary key 추가
ALTER table student add CONSTRAINT student_PK_NUM  PRIMARY key (num);

--java,spring 은 1~100만 가능하도록 check 제약조건 추가
 alter table student ADD CONSTRAINT student_CK_java check(java >=1 AND java <= 100);
 alter table student ADD CONSTRAINT student_CK_spring check(spring >=1 AND spring <= 100);
 
--ban 은 '햇님반','달님반','별님반' 만 추가할수 있도록 check 추가
 alter table student ADD CONSTRAINT student_CK_ban check(ban in('햇님반','달님반','별님반'));

--5개 정도 데이터 추가
insert into student (num,name,java,height,ban) VALUES(seq_stu.NEXTVAL, '오지오',89,179.2,'햇님반');
insert into student values (seq_stu.nextval,'이효리',178.5,67.5,88,'달님반');
insert into student values (seq_stu.nextval,'아라리',189.5,60.5,88,'별님반');
insert into student values (seq_stu.nextval,'오로리',125.5,13.5,88,'햇님반');
insert into student values (seq_stu.nextval,'이우리',75.5,18.5,88,'달님반');

commit;

--num이 6이상 모두삭제
delete from student where num >=6;
--num이 3인 사람의 java점수를 99로 , ban을 '달님반'으로 수정
update student set ban = '달님반', java = 99 where num=3;
--num=4 인사람의 키를 188.9로 수정
update student set height = 188.9 where num = 4;
--num2 인 데이터 삭제
delete from student where num =2;
--조회 이름 반 자바 스프링 총점 평균
select name 이름 ,ban 반, java 자바 , spring 스프링 , java+spring 총점, (java+spring)/2 평균 from student order by 총점 desc;
commit;

--DB 정규화(Normalization)
--정규화란 ? 한마이로 DB서버의 메모리를 낭비하지 않기 위해서 어떤 테이블 식별자를 가지는 여러개의 테이블로 나누는 과정을 정규화라고 한다
--정규화된 데이터베이는 중복의 최소화 되도록 설계된 데이터 베이스다
--장점 : 메모리를 절약할수 잇다
--        구조화된 시스템으로 인해서 관리가 편하다
--단저 : 조회비율이 매우높은 시스템의 경우에는 테이블간의 join 연산이 반복적으로
--        이루어지기 때문에 질의 응답속도가 살짝 늦어질수있다.

--student의 num을 외부키로 갖는 새로운 테이블 stuinfo 를 만들어보자
--외부키는 테이블 생성시 설정해도 되고 일단 생성후 테이블 수정으로 추가해도 된다.
--ppt 29p
create table stuinfo(
    idx number(5) constraint info_pk_idx PRIMARY key,
    num number(5),
    addr varchar2(20),
    hp varchar2(15)
);

--외부키 제약조건 추가
--stuinfo의 num 은 studnet의 num값만 넣을수 있도록 설정
alter table stuinfo add constraint info_fk_num foreign key(num) references student(num);

--stuinfo 의 num에 만약 3을 추가했다면 student 테이블에서 num=3인 데어터는 삭제할수없다
--제약조건 추가시 on delete cascade 를 추가했을경우는 부모테이블의 num=3인 데이터 삭제시
--stuinfo의 num=3인 모든 데이터는 자동 삭제된다

--stuinfo 에 데이터 추가하기
insert into stuinfo values (seq_stu.nextval,3,'서울시 강남구','010-2222-3333');

--student에 없는 2번을 추가해보
--ORA-02291: 무결성 제약조건(ANGEL.INFO_FK_NUM)이 위배되었습니다- 부모 키가 없습니다
insert into  stuinfo values (seq_stu.nextval,2,'서울시 강동구','010-4444-5555');

--다시 4번으로 추가
insert into  stuinfo values (seq_stu.nextval,4,'서울시 강동구','010-6666-7777');

--ORA-02291: 무결성 제약조건(ANGEL.INFO_FK_NUM)이 위배되었습니다- 부모 키가 없습니다
insert into  stuinfo values (seq_stu.nextval,5,'인천시 남구','010-8888-9999');
commit;

--조회
--각각 조회를 할 경우 모든 정보를 알수 없다
select * from student;
select * from stuinfo;

--join으로 두 테이블을 합쳐서 필요한 정보를 가지고 와보자
--ppt 43p
--inner join 또는 equi join 이라고 한다 . 서로 num 값이 같을 경우에만 가져온다
select sd.num 시퀀스, sd.name 학생명, sd.height 키, sd.ban 반, si.addr 주소, si.hp 핸드폰 ,sd.java 자바, sd.spring 스프링 
from student sd, stuinfo si
where sd.num = si.num;

--이떄 양쪽테이블에 공통적으로 가지고있는 컬럼을 제외하고는 앞에 테이블명 생략가능
select sd.num 시퀀스, name 학생명, height 키, ban 반, addr 주소, hp 핸드폰 ,java 자바, spring 스프링 
from student sd, stuinfo si
where sd.num = si.num;

--outer join 으로 추가되지 않은 데이터를 찾아보자
--sub 테이블 쪽에 (+)
select sd.num 시퀀스, name 학생명, height 키, ban 반, addr 주소, hp 핸드폰 ,java 자바, spring 스프링 
from student sd, stuinfo si
where sd.num = si.num(+) and addr is null;

--student(부모테이블) 의 num = 1인 데이터 삭제해보자
--ORA-02292: 무결성 제약조건(ANGEL.INFO_FK_NUM)이 위배되었습니다- 자식 레코드가 발견되었습니다
--이경우 만약 삭제룰 하고싶으면 stuinfo 의 데이터를 먼저 삭제후 student의 데이터를 삭제할수 있다
delete from student where num = 3;

--sub 테이블의 num=3 먼저삭제 후 부모테이블의 num=3 을 삭제해보자
delete from stuinfo where num = 3;
delete from student where num = 3;

--테이블 제거시 서브테이블 제거후 부모테이블 제거
drop table stuinfo;
drop table student;

--------------------------------------------------------------------------------
--이번에는 부모테이블의 데이터 삭제시 서브테이블의 데이터도 자동으로 삭제되도록
--외부키를 설정해보자
--시퀀스 생성
create SEQUENCE seq_shop;
--shop cart
create table shop(
    sang_no number(3) CONSTRAINT shop_pk_no PRIMARY key,
    sang_name varchar2(30),
    sang_price number(10)
);
--외부키 설정시 on delete cascade 를 붙이면 부모테이블 삭제시 자식테이블에 추가된 데이터도 삭제됨

create table cart(
    cart_no number(3) CONSTRAINT cart_pk_no PRIMARY key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    CONSTRAINT cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

--5개의 상품을 등록해보자
insert into shop values (seq_shop.nextval, '블라우스',120000);
insert into shop values (seq_shop.nextval, '조끼',15000);
insert into shop values (seq_shop.nextval, '청바지',78000);
insert into shop values (seq_shop.nextval, '코트',350000);
insert into shop values (seq_shop.nextval, '티셔츠',55000);
commit;

--3개의 제품을 카트에 담아보자
insert into cart values (seq_shop.nextval,2,3,sysdate);
insert into cart values (seq_shop.nextval,3,1,'2023-01-13');
insert into cart values (seq_shop.nextval,5,3,sysdate);
commit;

--조회
-- sang_no 상품번호, 상품명, 단가, 수량 , 구입일(년4 - 월2 - 일2 형식으로출력)
select sh.sang_no 시퀀스, sh.sang_name 상품명,to_char(sh.sang_price,'L999,999') 단가, ct.cnt 수량, to_char(ct.cartday,'yyyy-mm-dd') 구입일
from shop sh, cart ct
where sh.sang_no = ct.sang_no;

--cart에 담기지 않은 상품의 상품번호와 상품명 출력
select sh.sang_no 시퀀스, sh.sang_name 상품명,to_char(sh.sang_price,'L999,999') 단가, ct.cnt 수량, to_char(ct.cartday,'yyyy-mm-dd') 구입일
from shop sh, cart ct
where sh.sang_no = ct.sang_no(+) and ct.cnt is null;

--삭제 확인(2,3,5 상품이 cart에 담겨있음)
--shop 의 2번 3번 상품을 삭제후 cart 테이블 확인
--cart테이블에서 자동삭제
delete from shop where sang_no = 2 or  sang_no = 3;

--오늘 연습한 모든 테이블과 시퀀스를 제거
delete from shop;
delete from cart;
drop SEQUENCE seq1;
drop SEQUENCE seq3;
drop SEQUENCE seq_shop;
drop SEQUENCE seq_stu;
drop table cart;
drop table shop;
drop table person;

