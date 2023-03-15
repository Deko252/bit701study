--ppt 23������
--table ���� (person): ��ȣ, �̸�, ����, ����, ����, ���糯¥
create table person (
    num number(3) PRIMARY key,
    name varchar2(15) not NULL,
    age number(3),
    gender VARCHAR2(10) DEFAULT '����',
    city varchar2(15) DEFAULT '����',
    today DATE
);

--������ ��ȸ
select * from person;

-- insert
insert into person(num,name,today) VALUES (1,'SexyHong',sysdate);

--pk(primary key), nn(not null) �� ��� ���� �ȳ־��ָ� �����߻�-Ȯ��
insert into person(name, age, today) VALUES ('��ö��',23,'2022-09-18');

--nn�Ӽ��� �� �÷��� �����ǳ־�����Ѵ�,�̹����� num�� ���������� �־��
insert into person(num,name, age, today) VALUES (1,'��ö��',23,'2022-09-18');

--�������� �������� ������ �־��
insert into person(num,name, age, today) VALUES (2,'��ö��',23,'2022-09-18');

--�Ϻ� �÷��� �ƴ϶� ������� ��� �÷����� ������� �÷��� ��������
insert into person VALUES (3,'��÷��',52,'����','����','1895-05-12');
--���� 7������ �߰� �غ���
insert into person VALUES (4,'����',2,'����','����','1895-05-12');
insert into person VALUES (5,'������',5,'����','����','2023-06-12');
insert into person VALUES (6,'���̱�',36,'����','����','2012-11-19');
insert into person VALUES (7,'���̱�',25,'����','����','2011-12-17');
insert into person VALUES (8,'�丮��',89,'����','��õ','1999-01-13');
insert into person VALUES (9,'�ݰ���',15,'����','���','2002-09-17');
insert into person VALUES (10,'�ٳ���',29,'����','����','2014-04-28');
commit;

--�������� age, city ����
update person set age=26, city='���ֵ�' where name='�ٳ���';
--ȫ�浿�� ���� ����
update person set age=87 where name='SexyHong';
--������ today�� ���糯¥�� ����
update person set today=sysdate where name='���̱�';
commit;
--delete : where ������ �Ⱦ��� ��ü ��� ������
delete from person;

--�ٽ� �츮��
rollback; --������ Ŀ�� ���� ������ �ѹ�
--������ �̿��ؼ� ����
delete from person where name='����';

--���̰� 30�� �̸��ΰ�� ��� ����
delete from person where age <= 30;
rollback;

--���ݺ��ʹ� ���̺� ������ �����ϴ� ����
--���̺� �÷��߰�
ALTER table person add score number(3) default(50);

--�߰��� socre �÷��� ����
ALTER table person drop column score;

--�÷� Ÿ�� ����
alter table person modify city varchar2(20);

--�ķ��� ���� today->ipsaday �� ����
alter table person rename column today to ipsaday;

--���������� ���� : name �� not null ���������� ����ִ�(���������̸��� ���༭ �⺻���� �̸��� �� �ִ�)
--SYS_C008317
alter table person drop CONSTRAINT SYS_C008320;

--name �� ���ο� ������ �߰��غ���(UNIQUE)
alter table person ADD CONSTRAINT PERSON_UQ_NAME UNIQUE(NAME);

--�̸��� ���� �̸��� ����� ���������� �߻�
--ORA00001: ���Ἲ �������� (ANGEL.PERSON_UQ_NAME�� ����˴ϴ�;
insert into person (num,name) VALUES(50,'SexyHong'); --����

 --gender �� '����','����'�� �̿��� �����͸� ������ ������ �߻��ϰ�
 alter table person ADD CONSTRAINT person_CK_GENDER CHECK(GENDER IN('����','����'));
 
 --AGE�� 2 ~ 100 ���� �߰� �����ϵ��� ���������� �߰��غ���
 alter table person ADD CONSTRAINT person_CK_AGE check(AGE >=2 AND AGE <= 100);
 
 --�������ǿ� ����ǵ��� ���̸� �߰��غ���
insert into person (num,name,AGE) VALUES(100,'SexyHong',900);

--����
--PK���� ������ ������ PERSON_PX_NUM �̶�� ���ο� ���������� �߰��غ���
--SYS_C008321 ����
alter table person drop CONSTRAINT  SYS_C008321;
alter table person ADD CONSTRAINT PERSON_PX_NUM PRIMARY key (num);

--����
--BUSEO ��� �÷��� �߰� VARCHAR2(10) �⺻���� '������'
alter table person add BUSEO VARCHAR2(10) default('������');
--BUSEO �� �������� �߰� '������','ȫ����','�λ��' 3���� �߰��� �����ϵ���
alter table person ADD CONSTRAINT person_CK_BUSEO check(BUSEO in('������','ȫ����','�λ��'));
insert into person VALUES (10,'�ٳ���',29,'����','����','2014-04-28','�߶���');

--���� �达 �� �پ����� ���� ����� ��� '�λ��' �� ������ ����
update person set BUSEO='�λ��' where name LIKE '��%' or name LIKE '��%';

-- �̾� � �ƾ� ���� ���� ������� ��� 'ȫ����' �� ����
update person set BUSEO='ȫ����' where name like '��%' or name like '��%' or name like'��%';

--����
--���� ���� ��� ���� (����) ���ϱ� - �ο����� ������ ���� ���
alter table person add avg number(3,0);

select ceil(avg(age)) as ���� from person where GENDER = '����';
select ceil(avg(age)) ���� from person where GENDER = '����';

select gender ����, count(*) �ο���, ceil(avg(age)) ��ճ��� from person group by gender order by 2 desc;

--�μ����� �ο����� ��� ���� ���ϱ� - �μ����� �������� ���
select buseo �μ���, count(*) �ο���, ceil(avg(age)) ��ճ��� from person group by buseo order by 1;

--������ �����ϴ� ��� ppt 78 ������
--���� ���� ����ϴ� �⺻ ������ : 1���� 1�� �����ϴ� ������
create SEQUENCE seq1;
create SEQUENCE seq2 start with 10 increment by 10; --10�������� 10�� ����
create SEQUENCE seq3 start with 10 increment by 5 nocache; --nocache : cache�� 0����
create SEQUENCE seq4 MAXVALUE 100; --max ���� 100������ �߻�
--������ ��ȸ
select * from seq;
--���̺� ��ȸ
select * from tab;
--������ ����
drop SEQUENCE seq2;
drop SEQUENCE seq4;

--������ �߻� nextval, ���簪  currval
select seq1.nextval,seq3.nextval from dual; --�ݺ��ؼ� �����غ���

select seq1.currval,seq3.currval from dual; --������ �߻��� ��