"""
점수를 입력후 0~100 이 아니면 다시 입력
점수에 따른 평가 출력
"""
while True:
    score = int(input("숫자입력(종료999):"))
    if score ==999:
        break
    if score<0 or score > 100:
        print("0~100 사이의 값으로 다시 입력해주세요")
        continue
    print("입력한 점수는 {}점 입니다.".format(score))
    #if 로 평가
    if score >= 90:
       pungga="굳잡입니다 굳잡"
    elif score >=80:
        pungga="낫베드입니다 낫베드"
    else:
        pungga="베드입니다 베드"
    print("{}점 : {}".format(score,pungga))
print("바이바이")