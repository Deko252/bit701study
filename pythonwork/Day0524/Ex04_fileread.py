print("**d:/news.txt 읽기**")
f1 = open("d:/news.txt","r",encoding="UTF8")

s2 = f1.readlines()
f1.close()
print(s2)

for data in s2:
    print(data)