s1 =  "Have a Nice Day"
s2 = "Happy Day"
print(s1.startswith("Have"))#True
print(s1.startswith("Hppay"))#False
print(s2.endswith("Day"))#True
s3 = s1.replace(" ", "*")#공백제서
print(s3)
print(s1.count("a"))#s1 에서 a의 갯수 구하기
print(s1.lower(),s1.upper())# 소문자로 변환, 대문자로 전환
print("/".join(s1))#모든 글자상이에 /넣기
print(s1.isalpha())#모두 알파벳일경우 True
print(s2.isdigit)#모두 숫자일경우