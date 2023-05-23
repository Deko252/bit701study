"""
list 에 10개정도의 색상을 넣어놓고
방향키를 움직일때 마다 랜덤 색상으로 거북이가 해당 방향으로 10씩 이동하도록 한다
거북이 크기, 굵기 등은 모두 마음대로
"""

import turtle as t
import random as rnd
wn = t.Screen()
wn.colormode(255)
t.color(255,0,255)

def key_up():
    t.setheading(90)#위
    t.fd(int(rnd.randint(10,100)))
def key_down():
    t.setheading(270)#아래
    t.fd(int(rnd.randint(10,100)))
def key_left():
    t.setheading(180)#왼쪽
    t.fd(int(rnd.randint(10,100)))
def key_right():
    t.setheading(0)#오른쪽
    t.fd(int(rnd.randint(10,100)))


list=["red","pink","orange","green","gray"]
t.shape("turtle")
t.width(3)
t.shapesize(3) #크기는 3배
while True:
    r=rnd.randint(1,255)
    g=rnd.randint(1,255)
    b=rnd.randint(1,255)
    t.color(r,g,b) #그 랜덤값에 해당하는 색상으로 거북이 색상 변경
    t.onkeypress(key_up,"Up")#호출할 함수명, 키값(첫글자 반드시 대문자)
    t.onkeypress(key_down,"Down")#호출할 함수명, 키값(첫글자 반드시 대문자)
    t.onkeypress(key_left,"Left")#호출할 함수명, 키값(첫글자 반드시 대문자)
    t.onkeypress(key_right,"Right")#호출할 함수명, 키값(첫글자 반드시 대문자)
    t.listen()#키를 받을수 있도록 포커스를 그래픽 창으로 주는것
    
t.exitonclick()