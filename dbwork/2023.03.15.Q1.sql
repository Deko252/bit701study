--�����ϼ���
--
--seq_food ������
--
--restaurant  ���̺�
--
--    food_num �⺻Ű
--    food_name ���ڿ�(30)
--    food_price ����(7)
--    
--
--resorder ���̺�    
--     order_num �⺻Ű
--     order_name ���ڿ�(20)
--    food_num  ->restaurant �� food_num �� �ܺ�Ű�� ����(on delete cascade)
--    order_day ��¥Ÿ��(���೯¥)
--    jumun_day ��¥Ÿ��(���糯¥����)
--    inwon  ����(3)
--    
--
--
--1.����Ÿ �߰��ϱ�
--  ���İ�Ƽ   23000
--  ���캺���� 11000
--  ������  19000
--  ����Ƣ�� 10000
--  ¥��� 5000
--
--2.�ֹ� ���̺�
--�̻��,  ���İ�Ƽ�ֹ�, ������ 2023-11-20  �ֹ���:����ð���� �ο��� :4
--��ȣ��,���캺������ֹ�, ������ 2023-12-25  �ֹ���:����ð���� �ο��� :3
--��ȣ��,���������ֹ�, ������ 2023-12-20  �ֹ���:����ð���� �ο��� :3
--�̿���, ���İ�Ƽ�ֹ�, ������ 2023-05-11  �ֹ���:����ð���� �ο��� :2
--
--3.���
--�ֹ���  ������  ���ĸ�  ���İ���  �ֹ�����(��-��-�� ��:��)   �ο��� 
--
--4.������� �޴��� ������ ������ ���� ���̺����� �����Ǿ����� Ȯ���ϱ� 

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

insert into restaurant values(seq_food.nextval,'���İ�Ƽ',23000);
insert into restaurant values(seq_food.nextval,'���캺����',11000);
insert into restaurant values(seq_food.nextval,'������',19000);
insert into restaurant values(seq_food.nextval,'����Ƣ��',10000);
insert into restaurant values(seq_food.nextval,'¥���',5000);

insert into resorder values(seq_food.nextval,'�̻��',1,'2023-11-20',sysdate,4);
insert into resorder values(seq_food.nextval,'��ȣ��',2,'2023-12-25',sysdate,3);
insert into resorder values(seq_food.nextval,'��ȣ��',3,'2023-12-20',sysdate,3);
insert into resorder values(seq_food.nextval,'�̿���',1,'2023-05-11',sysdate,2);

select o.order_name �ֹ���,o.order_day ������, r.food_name ���ĸ�, r.food_price ���İ���,to_char(o.jumun_day,'yyyy-mm-dd-hh:mm')�ֹ���,inwon �ο���
from restaurant r, resorder o
where r.food_num = o.food_num;

delete from restaurant where food_num = 3;
