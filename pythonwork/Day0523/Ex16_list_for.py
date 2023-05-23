import turtle as t
list = ["red","purple","pink","green","orange","gray","yellow"]

t.speed(0)


# for count in range(6): #0~5
#     t.begin_fill()
#     t.color(list[count])
#     t.circle(100)
#     t.left(360/6)
#     t.end_fill()
# t.exitonclick()

for item in list:
    t.begin_fill()
    t.color(item)
    print(list.index(item),item)#인덱스값 출력, 색상 출력
    t.circle(100)
    t.left(360/6)
    t.end_fill()
t.exitonclick()