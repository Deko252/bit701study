let arr=[3,5,7];

let f1 = (a,b)=> console.log(a,b);

f1(arr[0],arr[1]);
f1(...arr);//펼침 연산자

let arr1 = [1,2];
let arr2 = [33,44,55];
let arr3 = [5,6,...arr1,...arr2];
console.log(arr3.length);
console.log(arr3);

//arr3의 총 합계
let sum = 0;
for (let a of arr3){
    //console.log(a);
    sum += a;
}
console.log("sum=" + sum);

sum = 0;
for (let i in arr3){
    //console.log(a);
    sum += arr3[i];
}
console.log("sum=" + sum);