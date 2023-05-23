"""
숫자를 반복ㅎ서 입력후 양수인지, 제로인지, 음수인지 등둥 출력하기
"""
while True:
    su = int(input("숫자입력(종료999):"))
    if su ==999:
        print("종료합니다.")
        break
    if su>0:
        print("{}는 양수입니다".format(su))
    elif su ==0:
        print("%d는 0입니다"%(su))
    else:
        print(su,"는 음수입니다")
print("바이바이")