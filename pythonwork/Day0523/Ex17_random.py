import random as r
import turtle as t

# rnd = r.randint(1,100) #1부터 100까지의 난수
# print(rnd)

ws=t.Screen()
ws.colormode(255)
while True:
    x = int(r.randint(-400,400))
    if x == 999:
        print("프로그램 종료")
        break
    y=int(r.randint(-400,400))

    t.penup()
    ws=t.Screen()
    t.shape("turtle")
    t.goto(x,y)
    red=r.randint(0,255)
    green=r.randint(0,255)
    blue=r.randint(0,255)
    t.color(red,green,blue)
    t.shapesize(3)
    t.write("Good!!",align="center",font=("Comic Sans MS",30,"bold"))