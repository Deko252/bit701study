-- EMP ���̺� ��ü �÷���ȸ
SELECT * from emp;
-- EMP ���̺� �ִ� ������ ������ ���(���������� �ѹ���)
SELECT DISTINCT job from emp;
-- �÷��� ��Ī�� ����
SELECT ename as "�����" , job as "����" from emp;
-- as ���� , ��Ī�� ���� �߰��� ����� ������ " ��������
select ename "���� �����", job ���� from emp;
-- ����: empno �� 7369, 7566 �ΰ��� ������ Ȯ��
select * from emp where empno = 7369 or empno = 7566;
-- SMITH,WARD�� ������ ���
select * from emp where ENAME='SMITH' or ENAME = "WARD";
--IN������
select * from EMP WHERE ENAME IN ('SMITH','WARD','FORD','SCOTT');
select * from emp where EMPNO IN(7369,7654,7788,7876);
--AND �������� ��ȸ�ϴ� ���
select ENAME, JOB, sal, comm FROM EMP WHERE SAL >= 1500 AND SAL <=3000;
--���� sql ���� between ���ε� ��ȸ����
select ENAME, JOB, sal, comm FROM EMP where sal between 1500 and 3000;
--������ MANAGER �� ����� SAL�� 2õ �̻��� ���
select * from emp where job = 'MANAGER' and sal >= 2000;
-- COMM�� NUlL �ΰ�츸 ���
select * from emp where comm is NULL;
-- COMM�� NUlL �� �ƴ� ��츸 ���
select * from emp where comm is not NULL;
--ENAME �� A�� �����ϴ� ������ ��ȸ
select * from emp where ENAME LIKE 'A%';
--ENAME �� S�� ������ ������ ��ȸ
select * from emp where ENAME LIKE '%S';
--ENAME �� A�� S�� �����ϴ� ������ ��ȸ
select * from emp where ENAME LIKE 'A%' or  ENAME LIKE 'S%';
--ENAME �� 2������ 3��° ���ڰ� A�λ��  ������ ��ȸ
select * from emp where ENAME LIKE '_A%' or ENAME LIKE '__A%';
--JOB�� MANAGER �� ANALYST �߿� SAL�� 2500�� ����� ��ȸ
select * from emp where JOB = 'ANALYST' OR JOB = 'MANAGER' AND SAL >= 2500;
--IN ���� ����
select * from emp where JOB in ('ANALYST' , 'MANAGER') AND SAL >= 2500;
--SCOTT�� ������ ���� ������ �޴� ��� ��ȸ
select * from emp where SAL = (select sal from emp WHERE ENAME = 'SCOTT'); 
--ALLEN �� ������ ���� ������ ���� ����� ��ȸ
select * from emp where JOB = (select job from emp where ename = 'ALLEN');