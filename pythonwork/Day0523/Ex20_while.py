"""
영어단어를 입력하면 리스트 목록에 추가
단, 영어가 아닌 글자가 포함시 경고표시후 다시입력
"q" 입력시 종료

종료후 1. 오름차순 2. 내림차순 3. 입력순 4. 종료
"""

englist=[]
while True:
    eng = input("영어단어를 입력해주세요. (종료:q)")
    if eng.lower()=="q":
        print("입력을 종료합니다")
        break
    if not eng.isalpha():
        print("경고 : 알파벳만 입력해주세요.")
        continue    #다시 처음으로 돌아간다
    if not eng.islower():
        print("경고 : 한글 숫자 안됩니다.")
        continue
    #둘다 해당하지않으면 eng.list에 추가
    englist.append(eng)

list = englist.copy()
while True:
    print("1.오름차순 2.내림차순 3.입력순 4.종료")
    n=int(input("번호를 입력해 주세요"))
    if n==4:
        print("종료")
        break
    if n==1:
        englist.sort()#오름차순
        print(englist)
    elif n==2:
        englist.sort(reverse=True)#내림차순
        print(englist)
    elif n==3:
        print(list)
    else:
        print("번호가 잘못 입력되었어요")