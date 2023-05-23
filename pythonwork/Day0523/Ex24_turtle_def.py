import turtle as t
import random as r

#이동할 거리길이를 입력해서 반환하는 함수 (입력을 다이얼로그로 받기)
def inp():
    n = int(r.randint(-100,100))
    # n=int(t.textinput("이동거리 입력","input number?"))
    return n

list=["red","pink","orange","green","gray"]
t.shape("turtle")
t.width(3)
t.shapesize(3) #크기는 3배
while True:
    n = inp()
    idx = r.randint(0,4) #0~4까지 랜덤값
    t.color(list[idx]) #그 랜덤값에 해당하는 색상으로 거북이 색상 변경
    t.fd(n) #입력한 길이 만큼 앞으로 전진
    t.setheading(abs(n))#거북이 머리 방향 회전
t.exitonclick()