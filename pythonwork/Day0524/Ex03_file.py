"""
파일변수 open("파일명","모드")
모드 : w 쓰기, r 읽기, a 추가
"""
import os
print(os.path.isfile("d:/data1.txt")) #파일이 존재하면 True
print(os.path.isfile("d:/mysql.sql"))
print(os.path.isdir("c:/bit701naver"))