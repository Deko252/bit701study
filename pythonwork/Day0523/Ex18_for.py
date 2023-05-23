for n in range(1,10,2):#1부터 9까지 2씩 증가한 값이 n 으로 넘어간다
    print(n,end=" ")#1,3,5,7,9
print()
for n in range(10,100,10): #10부터 90까지 10씩 증가된값
    print(n,end=" ")
print()

for n in ["apple", "banana","orange"]:#리스트의 각 값이 n 으로 넘어간다
    print(n,end=" ")
print()

list=["red","green","blue","white"]
for n in list:
    print(list.index(n),":",n) #0 : red 출력
print()

myBook={"책이름":"모두파이썬","출판사":"가메출판사","가격":9000000}
for n in myBook: #n키 값이 넘어간다.
    print(n,":",myBook.get(n))#책이름 : 모두파이썬 출력
