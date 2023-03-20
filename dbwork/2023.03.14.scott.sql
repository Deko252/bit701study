-- emp 테이블 전체 컬럼 조회
select * from emp;
--emp 테이블에 있는 직업의 종류를 출력(같은직업은 한번만)
select DISTINCT job from emp;
--컬럼명에 별칭을 지정
select ename as "사원명" ,job as "직업" from emp;
--as생략,별칭은 제목중간에 공백이 없을시 " 생략 가능
select ename "은행 사원명",job 직업 from emp;
--조건 : empno 가 7369,7566 두개의 데이타 확인
select * from emp where empno=7369 or empno=7566;
-- SMITH,WARD 의 데이타 출력
SELECT * FROM EMP WHERE ENAME='SMITH' OR ENAME='WARD';
--IN 연산자(OR 연산자로 조회하는경우 IN 으로도 조회 가능)
SELECT * FROM EMP WHERE ENAME IN ('SMITH','WARD','SCOTT','FORD');
SELECT * FROM EMP WHERE EMPNO IN (7369,7654,7788,7876);
--AND 연산으로 조화하는 경우
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE SAL>=1500 AND SAL<=3000;
--위의 SQL문을 BETWEEN 으로도 조회가 가능
SELECT ENAME,JOB,SAL,COMM FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
--직업이 MANAGER 인 사람중 SAL 이 2천 이상인사람
SELECT * FROM EMP WHERE JOB='MANAGER' AND SAL>=2000;
--COMM 이 NULL 인경우만 출력
SELECT * FROM EMP WHERE COMM IS NULL;
--COMM 이 NULL 이 아닌 경우만 출력
SELECT * FROM EMP WHERE COMM IS NOT NULL;
--ENAME 이 A로 시작하는 데이타 조회
SELECT * FROM EMP WHERE ENAME LIKE 'A%';
--ENAME 이 S로 끝나는 데이타 조회
SELECT * FROM EMP WHERE ENAME LIKE '%S';
--ENAME 이 A나 S로 시작하는 데이타 조회
SELECT * FROM EMP WHERE ENAME LIKE 'A%' OR ENAME LIKE 'S%';
--ENAME 의 2번째나 3번째 글자가 A인사람 조회
SELECT * FROM EMP WHERE ENAME LIKE '_A%' OR ENAME LIKE '__A%';
--JOB 이 MANAGER 나 ANALYST 중에 SAL 이 2500 이상인 사람만 조회
SELECT * FROM EMP WHERE (JOB='MANAGER' OR JOB='ANALYST') AND SAL>=2500;
--IN 으로 수정
SELECT * FROM EMP WHERE JOB IN ('MANAGER','ANALYST') AND SAL>=2500;
--SCOTT 의 연봉과 같은 연봉을 받는 사람을 조회-서브쿼리(SUBQUERY)
SELECT * FROM EMP WHERE SAL=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');
--ALLEN 의 직업과 같은 직업을 가진 사람들 조회하기
SELECT * FROM EMP WHERE JOB=(SELECT JOB FROM EMP WHERE ENAME='ALLEN');
--CONSOLE 에 출력시 테이블명을 DUAL
--PPT 48페이지 내장함수-숫자함수
SELECT ABS(-6),ABS(6) FROM DUAL; --ABS :절대값,무조건 양수로 출력
SELECT CEIL(2.75),CEIL(2.11) FROM DUAL;--무조건 올림을한 정수로 반환
SELECT FLOOR(2.75),FLOOR(2.11) FROM DUAL; --무조건 내림을 한 정수로 반환
SELECT ROUND(2.356,1),ROUND(2.22,1) FROM DUAL; --소숫점1째자리까지 구한다(반올림)
SELECT TRUNC(2.356,1),TRUNC(2.22,1) FROM DUAL;--소숫점1째자리까지 구한다 잘라냄(절삭)(반내림)
SELECT ROUND(235678,-1),ROUND(235678,-2) FROM DUAL;--235680,235700
SELECT POWER(2,3),POWER(3,4) FROM DUAL;--8,81 지수승구하기
SELECT MOD(7,2),MOD(10,2) FROM DUAL;--나머지 구하기  1,0

--49페이지 문자열 함수
SELECT CONCAT('JAVA','SPRING') FROM DUAL; --문자열합치기
--문자열을 합칠경우 || 이거로도 가능하다
SELECT 'JAVA'||'SPRING' FROM DUAL;
--table emp 로 해보기
select ename||'님의 직업은 '||job||'입니다' message from emp;--message 는 컬럼명
select ename||'님의 연봉은 '||sal||'만원입니다' sal from emp;
select initcap(ename) from emp;--첫글자만 대문자로 출력
select upper(ename),lower(ename) from emp;--대문자,소문자로 변환후 출력
--lpad,rpad :특정문자로 채우기
select lpad('happy',10,'*') from dual;
select rpad('happy',10,'*') from dual;
select ename,lpad(sal,10,'0') sal from emp;
--substr :문자열 추출
select substr('Happy Day',3,3),substr('Happy Day',-3,3) from dual;--ppy,Day
--ename 에서 앞 2글자만 출력후 * 3개 붙여서 출력하기
select substr(ename,1,2)||'***' ename from emp;
select rpad(substr(ename,1,2),5,'*') ename from emp;
--length 길이구하기
select ename||'님의 글자 길이는 '||length(ename)||'글자입니다' 메세지 from emp;
--replace :대치
select replace('Hello Kitty','t','*') from dual;
--instr:특정문자열의 위치 구하기
select instr('Good Day','Day') from dual;--6  :6번째에서 발견
select instr('Good Day','happy') from dual;--0 :없을경우 0
--trim : 양쪽 공백 제거
select '*'||trim('   hello   ')||'*' from dual; 
select '*'||ltrim('   hello   ')||'*' from dual; --왼쪽 공백만 제거
select '*'||rtrim('   hello   ')||'*' from dual; --오른쪽 공백만 제거

--sysdate 가 현재날짜 구하기
select sysdate from dual;
--내일 날짜 구하기
select sysdate+1 from dual;
--일주일뒤
select sysdate+7 from dual;
select to_char(sysdate,'yyyy-mm-dd') today from dual;--2023-03-14
select to_char(sysdate,'yyyy-mm-dd am hh:mi:ss') today from dual;--2023-03-14 오후 03:22:04
select to_char(sysdate,'yyyy-mm-dd hh24:mi:ss') today from dual;--2023-03-14 15:22:04
select to_char(2345678,'L999,999,999') from dual;-- ￦2,345,678
select to_char(2345678,'L000,000,000') from dual;-- ￦002,345,678
select to_char(2345678,'$999,999,999') from dual;-- $2,345,678
select to_char(2.3,'0.00') from dual; --2.30

--NVL :널값일경우 특정값으로 출력(Mysql 에서는 ifnull)
select NVL(mgr,1000),NVL(comm,0) from emp;
select sal+comm from emp;--comm 이 null 일경우 더하면 결과도 null
--comm 이 null 일경우 10으로 계산
select sal+NVL(comm,10) pay from emp;
--decode:값에 따라 서로 다른 값 출력
select ename,deptno,decode(deptno,10,'서울',20,'강원도',30,'경기도',40,'제주도') city from emp;

--order 순서대로 출력
select ename,sal from emp order by ename asc; --ename 의 오름차순(asc생략가능)
select ename,sal from emp order by sal desc;--sal 의 내림차순
--직업순 출력, 같은 직업일경우 연봉의 내림차순
select ename,job,sal from emp order by job,sal desc;
--sal 의 오름차순 출력시 sal 이 3번째 출력하므로 열번호 3으로 정렬
select ename,job,sal from emp order by 3;
--연봉 1500-3000 까지만 출력하는데 이름의 오름차순
select ename,sal from emp where sal between 1500 and 3000 order by ename;

--그룹함수 : ppt 57
--count,max,min,sum,avg
select count(*) from emp;--emp 의 데이타 갯수
select max(sal) from emp;--최고급여
select min(sal) from emp;--최저급여
select sum(sal) from emp;--급여의 합계
select round(avg(sal),-1) from emp;--급여의 평균,일원단위에서 반올림

--group 별 함수 적용
-- 각 직업별 인원수와 sal 의 평균을 구해보자
select job 직업,count(*) 인원수,round(avg(sal),-1) 평균연봉 from emp group by job;

--위의 궈리문에서 인원수가 작은거부터 출력
select job 직업,count(*) 인원수,round(avg(sal),-1) 평균연봉 from emp  group by job order by 인원수;

--위의 쿼리문에서 직업별 인원수가 3명 이상인 데이타만 출력
--그룹함수를 이용해서 조건을 나타낼때는 having 에서 준다
select job 직업,count(*) 인원수,round(avg(sal),-1) 평균연봉 from emp  
        group by job having count(*)>=3 order by 인원수;

--각 직업별로 인원수와 최고연봉,최저연봉을 출력(직업의 오름차순)
select job 직업,count(*) 인원수,max(sal) 최고연봉,min(sal) 최저연봉
        from emp group by job order by 1;-- 1 컬럼번호 대신 직업 해도됨
        
--위의 쿼리문에 금액앞에 화폐단위를 붙이고 3자리컴마 추가하려면
select job 직업,count(*) 인원수,to_char(max(sal),'L999,999') 최고연봉,
        to_char(min(sal),'L999,999') 최저연봉
        from emp group by job order by 1;
        
--문제 
--1. emp테이블에서 ename a나 s로 시작하는사람 출력(대소문자 상관없음)
  SELECT * FROM EMP WHERE UPPER(ENAME) LIKE 'A%' OR UPPER(ENAME) LIKE 'S%';
--2. emp테이블에서 ename 에서 두번째 글자가 'A' 인사람 출력
  SELECT * FROM EMP WHERE ENAME LIKE '_A%';
--3. job 에서 같은 직업군일경우 한번씩만 출력하시오
  SELECT DISTINCT JOB FROM EMP;  
--4. job 종류별로 인원수를 구하시오
  SELECT JOB,COUNT(*) 인원수 FROM EMP GROUP BY JOB;
--5. job 종류별로 sal 의 평균급여를 구하시오
  SELECT JOB,ROUND(AVG(SAL),0) 평균급여 FROM EMP GROUP BY JOB;
--6. job 종류별로 sal 의 최대값과 최소값을 구하시오
  SELECT JOB,MAX(SAL),MIN(SAL) FROM EMP GROUP BY JOB;
--7. deptno 가 10인경우 '홍보부'
--   20 인경우 '개발부' 30인경우 '관리부' 부서를 구하여
--   ename, 부서 를 출력하시오
   SELECT ENAME,DEPTNO,DECODE(DEPTNO,10,'홍보부',20,'개발부',30,'관리부') FROM EMP;   
--8. 급여(sal)가 sal 의 평균보다 더 높은 사람만 ename 과 sal 을 출력하시오
    SELECT ENAME,SAL FROM EMP WHERE SAL>(SELECT AVG(SAL) FROM EMP);
--9. hiredate 에서 월이 5월인 사람만 ename 과 hiredate 를 출력하시오
   SELECT ENAME,HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'MM')='05';
   SELECT ENAME,HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE,'MM')=5;
   
--10. SCOTT 의 급여와 동일하거나 더 많이 받는 사원명과 급여를 출력하라
  SELECT ENAME,SAL FROM EMP WHERE SAL>=(SELECT SAL FROM EMP WHERE ENAME='SCOTT');