class AA {
    constructor(){
        console.log("부모 생성자");
    }
}

class BB extends AA{
    constructor(){
        super();//생략안됨
        console.log("자식생성자");
    }
}

let a = new BB();

///////////////////////////////
class CC{
    constructor(name){
        this.name = name;
    }

    printA(){
        console.log("내이름은 " + this.name);
    }
}


class DD extends CC{
    constructor(name, age){
        super(name);
        this.age = age;
    }

    printAII(){
        this.printA();
        console.log("내 나이는" + this.age + "세");
    }
}

let b = new DD("마이클",34);
b.printAII();