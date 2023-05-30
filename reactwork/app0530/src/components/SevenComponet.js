import React, {useRef, useState} from 'react';
import SevenChildApp from "./SevenChildApp";
import SevenChildApp2 from "./SevenChildApp2";
/*
* 부모 자식간 통신(데이터주고받기) 하기
* 1. 부모 컴포넌트에서 자식 커모넌트로 props 를 통해서 값이나 이벤트를 전달할 수 잇다.
* 2. 자식컴포넌트에서는 부모컴포넌트의 값을 props 로 받아서 출력은 가능하지만 직접 변경은 불가능하다
* 3. 만약 부득이하게 변경을 해야할경우 props 로 전달받은 이벤트를 통해서 값변경을 할 수 있다.
* 4. 자식컴포넌트로 보낼 props는 부모만이 정할 수 있으며 자식 컴포넌트에서는 읽기만 가능(값일 경우)
* */
function SevenComponet(props) {
    const [count, setCount] = useState(0);

    const countIncre = () => setCount(count+1);
    return (
        <div>
            <h2 className="alert alert-info">SevenComponet - 부모 자식 통신</h2>
            <h2 className="alert alert-success">방문 횟수 : {count}</h2>
            <SevenChildApp name={"캔디"} age={502} onIncre={countIncre}/>
            <SevenChildApp name={"테리우스"} age={602} onIncre={countIncre}/>
            <SevenChildApp name={"이라이자"} age={12} onIncre={countIncre}/>
            <SevenChildApp2 photoname="과제1" photoprice="6조7000억" photo="1.JPG"/>
            <SevenChildApp2 photoname="과제4" photoprice="5억" photo="4.JPG"/>
        </div>
    );
}

export default SevenComponet;