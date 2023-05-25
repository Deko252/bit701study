class Student{
    constructor(name)
    {
        console.log("생성자 호출");
        this.name = name;
    }
}

//클래스를 생성
let s1 = new Student("섹시홍");
console.log(s1.name);

let s2 = new Student("홍섹시");
console.log(s2.name);

//sawon 이라는 클래스
let Sawon=class{
    constructor(name, buseo){
        this.name = name;
        this.buseo = buseo;
    }
    //멤버 매서드
    printSawon(){
        console.log(`사원명 : ${sw1.name}님은 부셔명 : ${sw1.buseo}에 속해 있습니다.`);
    }
    static title(){
        console.log(`이거다`);
    }
}

let sw1 = new Sawon("섹시홍","영업부");
console.log(sw1.name+":",sw1.buseo);
console.log(`${sw1.name}님은 ${sw1.buseo}에 속해 있습니다.`);


//정적 메서드 호출
Sawon.title();
//메서드 호출
sw1.printSawon();