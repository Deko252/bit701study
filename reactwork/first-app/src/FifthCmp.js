import React, { useState } from 'react';
import "./mystyle.css";

function FifthCmp(props) {
    const [name,setName] = useState("아오지");
    const [addr,setAddr] = useState("신의주");
    return (
        <div>
            <h2 className="title">5번째 컴포넌트</h2>
            <div style={{fontSize:"2em",fontFamily:"Hi Melody"}}>
                이름 : {name}<br/>
                주소 : {addr}
            </div>

            <input type="text" value={name} placeholder="이름을 입력하세요."
            onChange={(e) =>{
                setName(e.target.value);
            }}/>
            <br/>
            <input type="text" value={addr} placeholder="이름을 입력하세요."
                   onChange={(e) =>{
                       setAddr(e.target.value);
                   }}/>
        </div>
    );
}

export default FifthCmp;