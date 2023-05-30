import React, {useState, useRef} from 'react';
function ThreeComponet(props) {
    const [count, setCount] = useState(1);
    const countRef = useRef(1);
    console.log("랜더링 중...");
    const stateIncreEvent = () =>{
        setCount(count+1);//값이 변경될때마다 랜더링 발생
    }

    const refIncreEvent = () =>{
        countRef.current=countRef.current+1;//값은 변경되지만 랜더링 되지않는다.
        console.log("countRef변수값 : " + countRef.current);
    }
    return (
        <div>
            <h2 className="alert alert-info">ThreeComponet</h2>
            <h1>state:{count}</h1>
            <h1>Ref:{countRef.current}</h1>
            <button type="button" onClick={stateIncreEvent}>증가 - state 변수 증가</button>
            <button type="button" onClick={refIncreEvent}>증가 - ref로 변수 증가</button>
        </div>
    );
}

export default ThreeComponet;