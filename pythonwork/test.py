#r,g,b 색상과 반지름을 입력하면 해당 색상으로 채워진 원을 그리시오
import turtle as t
ws=t.Screen()
ws.colormode(255)


r=int(input("색상의 R값 입력:"))
g=int(input("색상의 G값 입력:"))
b=int(input("색상의 B값 입력:"))
rad=int(input("반지름 입력:"))
t.color((r,g,b))
t.begin_fill()
t.circle(rad)
t.end_fill()
t.exitonclick()