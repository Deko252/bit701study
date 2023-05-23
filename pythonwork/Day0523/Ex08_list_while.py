import turtle as t
colors = ["red","purple","pink","green","orange","gray","yellow"]
t.bgcolor("black")
t.speed(0)
t.width(3)
length=10

#반복문 while
while length<500:
    t.forward(length)
    t.pencolor(colors[length%7])
    t.right(144)#144도 회전해서 우측으로 이동
    length += 5
t.exitonclick()