def test():
    a=5 #지역변수

def test2():
    global b #모든 함수에서 이용가능한 전역변수
    b = 10

def test3():
    print("b=",b)

#test()
#print("a=",a) #오류 a는 test() 함수안에서만 사용가능한 변수이므로 선언안됐다는 오류

a=10
test()
print("a=",a)

test2()
print("b=",b)
test3()