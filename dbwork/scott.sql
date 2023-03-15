-- EMP 테이블 전체 컬럼조회
SELECT * from emp;
-- EMP 테이블에 있는 직업의 종류를 출력(같은직업은 한번만)
SELECT DISTINCT job from emp;
-- 컬럼명에 별칭을 지정
SELECT ename as "사원명" , job as "직업" from emp;
-- as 생략 , 별칭은 제목 중간에 공백기 없을시 " 생략가능
select ename "은행 사원명", job 직업 from emp;
-- 조건: empno 가 7369, 7566 두개의 데이터 확인
select * from emp where empno = 7369 or empno = 7566;
-- SMITH,WARD의 데이터 출력
select * from emp where ENAME='SMITH' or ENAME = "WARD";
--IN연산자
select * from EMP WHERE ENAME IN ('SMITH','WARD','FORD','SCOTT');
select * from emp where EMPNO IN(7369,7654,7788,7876);
--AND 연산으로 조회하는 경우
select ENAME, JOB, sal, comm FROM EMP WHERE SAL >= 1500 AND SAL <=3000;
--위의 sql 문을 between 으로도 조회가능
select ENAME, JOB, sal, comm FROM EMP where sal between 1500 and 3000;
--직업이 MANAGER 인 사람중 SAL이 2천 이상인 사람
select * from emp where job = 'MANAGER' and sal >= 2000;
-- COMM이 NUlL 인경우만 출력
select * from emp where comm is NULL;
-- COMM이 NUlL 이 아닌 경우만 출력
select * from emp where comm is not NULL;
--ENAME 이 A로 시작하는 데이터 조회
select * from emp where ENAME LIKE 'A%';
--ENAME 이 S로 끝나는 데이터 조회
select * from emp where ENAME LIKE '%S';
--ENAME 이 A나 S로 시작하는 데이터 조회
select * from emp where ENAME LIKE 'A%' or  ENAME LIKE 'S%';
--ENAME 이 2번쨰나 3번째 글자가 A인사람  데이터 조회
select * from emp where ENAME LIKE '_A%' or ENAME LIKE '__A%';
--JOB이 MANAGER 나 ANALYST 중에 SAL이 2500인 사람만 조회
select * from emp where JOB = 'ANALYST' OR JOB = 'MANAGER' AND SAL >= 2500;
--IN 으로 수정
select * from emp where JOB in ('ANALYST' , 'MANAGER') AND SAL >= 2500;
--SCOTT읜 연봉과 같은 연봉을 받는 사람 조회
select * from emp where SAL = (select sal from emp WHERE ENAME = 'SCOTT'); 
--ALLEN 의 직업과 같은 직업을 사진 사람을 조회
select * from emp where JOB = (select job from emp where ename = 'ALLEN');