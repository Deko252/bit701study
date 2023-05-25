let f1 =()=>"Hello"; //return "Hello" 의미 : 한줄일 경우 return 생략

console.log(f1);//f1 함수 호출

let f2 = (a,b) => "a*b";//인자로 받은 두수를 곱한값을 반환

console.log("3*4 는", f2(3,4));
console.log(f2(5))

let f3 =(x=1, y=2, z=3)=> x+y+x;

console.log(f3(4));
console.log(f3(10,20));
console.log(f3(10,20,30));

