import turtle as t

t.color("pink")
t.begin_fill()#색채우기 시작
t.pencolor("blue")#펜 색상
t.width(5)#펜굵기
t.speed(4)#0~10: 0은 10과 같이 가장 빠른속도
t.shape("turtle")
n=4
for x in range(n):
    t.fd(70)
    t.lt(360/n)
t.end_fill()
t.exitonclick()