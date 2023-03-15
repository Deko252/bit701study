--����
--���̺� ���� (student) : num  ����(5) , name ���ڿ�(10), height ����(5,1),
--java ����(3) �⺻�� 10, spring ����(3) �⺻��(10), ban ���ڿ�(20)
create table student (
     num number(5),
     name varchar2(10),
     height number(5,1),
     java number(3) DEFAULT(10),
     spring number(3) DEFAULT(10),
     ban varchar2(20)
);

select * from student;

--������ ���� seq_stu �⺻(1���� 1������), nocache �߰�
create SEQUENCE seq_stu nocache;
select * from seq;
--�������ǵ� �߰�
--num �� primary key �߰�
ALTER table student add CONSTRAINT student_PK_NUM  PRIMARY key (num);

--java,spring �� 1~100�� �����ϵ��� check �������� �߰�
 alter table student ADD CONSTRAINT student_CK_java check(java >=1 AND java <= 100);
 alter table student ADD CONSTRAINT student_CK_spring check(spring >=1 AND spring <= 100);
 
--ban �� '�޴Թ�','�޴Թ�','���Թ�' �� �߰��Ҽ� �ֵ��� check �߰�
 alter table student ADD CONSTRAINT student_CK_ban check(ban in('�޴Թ�','�޴Թ�','���Թ�'));

--5�� ���� ������ �߰�
insert into student (num,name,java,height,ban) VALUES(seq_stu.NEXTVAL, '������',89,179.2,'�޴Թ�');
insert into student values (seq_stu.nextval,'��ȿ��',178.5,67.5,88,'�޴Թ�');
insert into student values (seq_stu.nextval,'�ƶ�',189.5,60.5,88,'���Թ�');
insert into student values (seq_stu.nextval,'���θ�',125.5,13.5,88,'�޴Թ�');
insert into student values (seq_stu.nextval,'�̿츮',75.5,18.5,88,'�޴Թ�');

commit;

--num�� 6�̻� ��λ���
delete from student where num >=6;
--num�� 3�� ����� java������ 99�� , ban�� '�޴Թ�'���� ����
update student set ban = '�޴Թ�', java = 99 where num=3;
--num=4 �λ���� Ű�� 188.9�� ����
update student set height = 188.9 where num = 4;
--num2 �� ������ ����
delete from student where num =2;
--��ȸ �̸� �� �ڹ� ������ ���� ���
select name �̸� ,ban ��, java �ڹ� , spring ������ , java+spring ����, (java+spring)/2 ��� from student order by ���� desc;
commit;

--DB ����ȭ(Normalization)
--����ȭ�� ? �Ѹ��̷� DB������ �޸𸮸� �������� �ʱ� ���ؼ� � ���̺� �ĺ��ڸ� ������ �������� ���̺�� ������ ������ ����ȭ��� �Ѵ�
--����ȭ�� �����ͺ��̴� �ߺ��� �ּ�ȭ �ǵ��� ����� ������ ���̽���
--���� : �޸𸮸� �����Ҽ� �մ�
--        ����ȭ�� �ý������� ���ؼ� ������ ���ϴ�
--���� : ��ȸ������ �ſ���� �ý����� ��쿡�� ���̺��� join ������ �ݺ�������
--        �̷������ ������ ���� ����ӵ��� ��¦ �ʾ������ִ�.

--student�� num�� �ܺ�Ű�� ���� ���ο� ���̺� stuinfo �� ������
--�ܺ�Ű�� ���̺� ������ �����ص� �ǰ� �ϴ� ������ ���̺� �������� �߰��ص� �ȴ�.
--ppt 29p
create table stuinfo(
    idx number(5) constraint info_pk_idx PRIMARY key,
    num number(5),
    addr varchar2(20),
    hp varchar2(15)
);

--�ܺ�Ű �������� �߰�
--stuinfo�� num �� studnet�� num���� ������ �ֵ��� ����
alter table stuinfo add constraint info_fk_num foreign key(num) references student(num);

--stuinfo �� num�� ���� 3�� �߰��ߴٸ� student ���̺��� num=3�� �����ʹ� �����Ҽ�����
--�������� �߰��� on delete cascade �� �߰��������� �θ����̺��� num=3�� ������ ������
--stuinfo�� num=3�� ��� �����ʹ� �ڵ� �����ȴ�

--stuinfo �� ������ �߰��ϱ�
insert into stuinfo values (seq_stu.nextval,3,'����� ������','010-2222-3333');

--student�� ���� 2���� �߰��غ�
--ORA-02291: ���Ἲ ��������(ANGEL.INFO_FK_NUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�
insert into  stuinfo values (seq_stu.nextval,2,'����� ������','010-4444-5555');

--�ٽ� 4������ �߰�
insert into  stuinfo values (seq_stu.nextval,4,'����� ������','010-6666-7777');

--ORA-02291: ���Ἲ ��������(ANGEL.INFO_FK_NUM)�� ����Ǿ����ϴ�- �θ� Ű�� �����ϴ�
insert into  stuinfo values (seq_stu.nextval,5,'��õ�� ����','010-8888-9999');
commit;

--��ȸ
--���� ��ȸ�� �� ��� ��� ������ �˼� ����
select * from student;
select * from stuinfo;

--join���� �� ���̺��� ���ļ� �ʿ��� ������ ������ �ͺ���
--ppt 43p
--inner join �Ǵ� equi join �̶�� �Ѵ� . ���� num ���� ���� ��쿡�� �����´�
select sd.num ������, sd.name �л���, sd.height Ű, sd.ban ��, si.addr �ּ�, si.hp �ڵ��� ,sd.java �ڹ�, sd.spring ������ 
from student sd, stuinfo si
where sd.num = si.num;

--�̋� �������̺� ���������� �������ִ� �÷��� �����ϰ�� �տ� ���̺�� ��������
select sd.num ������, name �л���, height Ű, ban ��, addr �ּ�, hp �ڵ��� ,java �ڹ�, spring ������ 
from student sd, stuinfo si
where sd.num = si.num;

--outer join ���� �߰����� ���� �����͸� ã�ƺ���
--sub ���̺� �ʿ� (+)
select sd.num ������, name �л���, height Ű, ban ��, addr �ּ�, hp �ڵ��� ,java �ڹ�, spring ������ 
from student sd, stuinfo si
where sd.num = si.num(+) and addr is null;

--student(�θ����̺�) �� num = 1�� ������ �����غ���
--ORA-02292: ���Ἲ ��������(ANGEL.INFO_FK_NUM)�� ����Ǿ����ϴ�- �ڽ� ���ڵ尡 �߰ߵǾ����ϴ�
--�̰�� ���� ������ �ϰ������ stuinfo �� �����͸� ���� ������ student�� �����͸� �����Ҽ� �ִ�
delete from student where num = 3;

--sub ���̺��� num=3 �������� �� �θ����̺��� num=3 �� �����غ���
delete from stuinfo where num = 3;
delete from student where num = 3;

--���̺� ���Ž� �������̺� ������ �θ����̺� ����
drop table stuinfo;
drop table student;

--------------------------------------------------------------------------------
--�̹����� �θ����̺��� ������ ������ �������̺��� �����͵� �ڵ����� �����ǵ���
--�ܺ�Ű�� �����غ���
--������ ����
create SEQUENCE seq_shop;
--shop cart
create table shop(
    sang_no number(3) CONSTRAINT shop_pk_no PRIMARY key,
    sang_name varchar2(30),
    sang_price number(10)
);
--�ܺ�Ű ������ on delete cascade �� ���̸� �θ����̺� ������ �ڽ����̺� �߰��� �����͵� ������

create table cart(
    cart_no number(3) CONSTRAINT cart_pk_no PRIMARY key,
    sang_no number(3),
    cnt number(3),
    cartday date,
    CONSTRAINT cart_fk_no foreign key(sang_no) references shop(sang_no) on delete cascade
);

--5���� ��ǰ�� ����غ���
insert into shop values (seq_shop.nextval, '���콺',120000);
insert into shop values (seq_shop.nextval, '����',15000);
insert into shop values (seq_shop.nextval, 'û����',78000);
insert into shop values (seq_shop.nextval, '��Ʈ',350000);
insert into shop values (seq_shop.nextval, 'Ƽ����',55000);
commit;

--3���� ��ǰ�� īƮ�� ��ƺ���
insert into cart values (seq_shop.nextval,2,3,sysdate);
insert into cart values (seq_shop.nextval,3,1,'2023-01-13');
insert into cart values (seq_shop.nextval,5,3,sysdate);
commit;

--��ȸ
-- sang_no ��ǰ��ȣ, ��ǰ��, �ܰ�, ���� , ������(��4 - ��2 - ��2 �����������)
select sh.sang_no ������, sh.sang_name ��ǰ��,to_char(sh.sang_price,'L999,999') �ܰ�, ct.cnt ����, to_char(ct.cartday,'yyyy-mm-dd') ������
from shop sh, cart ct
where sh.sang_no = ct.sang_no;

--cart�� ����� ���� ��ǰ�� ��ǰ��ȣ�� ��ǰ�� ���
select sh.sang_no ������, sh.sang_name ��ǰ��,to_char(sh.sang_price,'L999,999') �ܰ�, ct.cnt ����, to_char(ct.cartday,'yyyy-mm-dd') ������
from shop sh, cart ct
where sh.sang_no = ct.sang_no(+) and ct.cnt is null;

--���� Ȯ��(2,3,5 ��ǰ�� cart�� �������)
--shop �� 2�� 3�� ��ǰ�� ������ cart ���̺� Ȯ��
--cart���̺��� �ڵ�����
delete from shop where sang_no = 2 or  sang_no = 3;

--���� ������ ��� ���̺�� �������� ����
delete from shop;
delete from cart;
drop SEQUENCE seq1;
drop SEQUENCE seq3;
drop SEQUENCE seq_shop;
drop SEQUENCE seq_stu;
drop table cart;
drop table shop;
drop table person;