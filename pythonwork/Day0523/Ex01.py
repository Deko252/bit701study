import time as ti
#현재 년도 구하기
curYear=ti.localtime().tm_year;
#현재 월 구하기
curMonth=ti.localtime().tm_mon;
print(curYear, curMonth)
#태어난 년도를 입력받아 나이를 구해보자
birthYear=input("태어난 년도를 입력하세요.")
print(type(birthYear))#type 이 str로 나옴
age=curYear-int(birthYear);
print("내 나이는 ", age , " 세입니다.")