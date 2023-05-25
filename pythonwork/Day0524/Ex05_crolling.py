#C:\Users\유찬혁\AppData\Local\Programs\Python\Python311\Scripts


import requests
import vendor

req = requests.get("https://www.hankookilbo.com/")

#html 소스 가져오기
html = req.text

#html header 가져오기
header = req.headers

#http status 가져오기(200:ok)
status = req.status_code

#http가 정상적으로 되었는지 (True/False)
is_ok = req.ok

print("*** html ***")
#print(html)


print("*** header ***")
print(header)

print("*** status ***")
print(status)

print("*** is_ok ***")
print(is_ok)