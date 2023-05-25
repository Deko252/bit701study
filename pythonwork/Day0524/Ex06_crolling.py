#C:\Users\유찬혁\AppData\Local\Programs\Python\Python311\Scripts
import requests
from bs4 import BeautifulSoup

req = requests.get("https://music.bugs.co.kr/newest")

html=req.text

#html 소스 파이썬 객체로 변환하기
soup = BeautifulSoup(html, "html.parser")

#select 를 통해서 html 요소를 찾아낸다
tiles = soup.select("section.sectionPadding div.albumTitle>a")
#print(tiles)

for atag in tiles:
    print(tiles.index(atag)+1, ":" ,atag.text)
