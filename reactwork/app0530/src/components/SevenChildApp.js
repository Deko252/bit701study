import React, {useRef, useState} from 'react';

//방법 1
/*function SevenChildApp(props) {

    return (
        <div>
            <h5 className="alert alert-danger" style={{border:"3px soid pink",fontFamily:"Jua",marginBottom:"10px"}}>Seven의 자식 컴포넌트
                : 나의 이름은 {props.name}이다. 내 나이는 {props.age}세다
                <button type="button" className="btn btn-info btn-sm"
                    onClick={props.onIncre}
                >증가</button>
            </h5>
        </div>
    );
}*/

//방법 2
/*function SevenChildApp(props) {
    const {name,age,onIncre} = props;
    return (
        <div>
            <h5 className="alert alert-danger" style={{border:"3px soid pink",fontFamily:"Jua",marginBottom:"10px"}}>Seven의 자식 컴포넌트
                : 나의 이름은 {name}이다. 내 나이는 {age}세다
                <button type="button" className="btn btn-info btn-sm"
                        onClick={onIncre}
                >증가</button>
            </h5>
        </div>
    );
}*/

//방법 3
function SevenChildApp({name,age,onIncre}) {
    return (
        <div>
            <h5 className="alert alert-danger" style={{border:"3px soid pink",fontFamily:"Jua",marginBottom:"10px"}}>Seven의 자식 컴포넌트
                : 나의 이름은 {name}이다. 내 나이는 {age}세다
                <button type="button" className="btn btn-info btn-sm"
                        onClick={onIncre}
                >증가</button>
            </h5>
        </div>
    );
}

export default SevenChildApp;