import mydef
import turtle

ws=turtle.Screen()
ws.colormode(255)
#turtle 여러개 생성
# t1 = turtle.Turtle()
# t2 = turtle.Turtle()
# t3 = turtle.Turtle()
# t4 = turtle.Turtle()

# mydef.showturtle(t1)
# mydef.showturtle(t2)
# mydef.showturtle(t3)
# mydef.showturtle(t4)

def inp():
    n = int(r.randint(-100,100))
    # n=int(t.textinput("이동거리 입력","input number?"))
    return n

list=[]
for i in range(0,100):
    t = turtle.Turtle()
    list.append(t)
for n in list:
    mydef.showturtle(n)

turtle.exitonclick()