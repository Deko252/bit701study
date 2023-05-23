for n in range(5): #0~4
    print(n,end=" ")#n 값 출력, 옆으로 공백
print()
print("="*30)
for n in range(1,5):#1~5
    print(n, end=" ")#n 값출력, 옆으로 공백
print()
print("="*30)

#1~100 까지의 합을 구하기
sum = 0
for n in range(1,101):
    sum += n
print(sum)