--연습하세요
--
--seq_food 시퀀스
--
--restaurant  테이블
--
--    food_num 기본키
--    food_name 문자열(30)
--    food_price 숫자(7)
--    
--
--resorder 테이블    
--     order_num 기본키
--     order_name 문자열(20)
--    food_num  ->restaurant 의 food_num 을 외부키로 설정(on delete cascade)
--    order_day 날짜타입(예약날짜)
--    jumun_day 날짜타입(현재날짜저장)
--    inwon  숫자(3)
--    
--
--
--1.데이타 추가하기
--  스파게티   23000
--  새우볶음밥 11000
--  전복죽  19000
--  새우튀김 10000
--  짜장면 5000
--
--2.주문 테이블
--이상아,  스파게티주문, 예약일 2023-11-20  주문일:현재시간등록 인원수 :4
--강호동,새우볶음밥밥주문, 예약일 2023-12-25  주문일:현재시간등록 인원수 :3
--강호동,전복죽죽주문, 예약일 2023-12-20  주문일:현재시간등록 인원수 :3
--이영자, 스파게티주문, 예약일 2023-05-11  주문일:현재시간등록 인원수 :2
--
--3.출력
--주문자  예약일  음식명  음식가격  주문문일(연-월-일 시:분)   인원수 
--
--4.레스토랑 메뉴중 전복죽 삭제후 에약 테이블에서도 삭제되었는지 확인하기 

create SEQUENCE seq_food ;

create table restaurant (
    food_num number(5) CONSTRAINT restaurant_pk_num PRIMARY key,
    food_name varchar2(30),
    food_price number(7)
);
create table resorder (
    order_num  number(5)CONSTRAINT resorder_pk_num PRIMARY key,
    order_name  varchar2(30),
    food_num number(5),
    order_day date,
    jumun_day date,
    inwon number(3),
    CONSTRAINT resorder_fk_no foreign key(food_num) references restaurant(food_num) on delete cascade
);

insert into restaurant values(seq_food.nextval,'스파게티',23000);
insert into restaurant values(seq_food.nextval,'새우볶음밥',11000);
insert into restaurant values(seq_food.nextval,'전복죽',19000);
insert into restaurant values(seq_food.nextval,'새우튀김',10000);
insert into restaurant values(seq_food.nextval,'짜장면',5000);

insert into resorder values(seq_food.nextval,'이상아',1,'2023-11-20',sysdate,4);
insert into resorder values(seq_food.nextval,'강호동',2,'2023-12-25',sysdate,3);
insert into resorder values(seq_food.nextval,'강호동',3,'2023-12-20',sysdate,3);
insert into resorder values(seq_food.nextval,'이영자',1,'2023-05-11',sysdate,2);

select o.order_name 주문자,o.order_day 예약일, r.food_name 음식명, r.food_price 음식가격,to_char(o.jumun_day,'yyyy-mm-dd-hh:mm')주문일,inwon 인원수
from restaurant r, resorder o
where r.food_num = o.food_num;

delete from restaurant where food_num = 3;
