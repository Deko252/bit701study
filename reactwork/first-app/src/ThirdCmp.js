import React from 'react';
import "./mystyle.css";

function ThirdCmp(props) {
    const style1={
        fontFamily:"Nanum Pen Script",
        fontSize:"26px",
        color:"purple",
        border:"3px solid gold",
        backgroundColor:"#66ccaa"
    }
    const style2={
        textAlign:"center",
        border:"10px solid gray",
        width:"200px",
        height:"150px",
        marginLeft:"150px"
    }
    let myName="사탕";
    let myAddr="서울시 강서구";
    {/* 위의 두 변수값은 출력만 가능하다, 변경은 안됨*/}
    return (
        <div>
            <h3 style={style1}>세번째 컴포넌트</h3>
            <div style={style2}>
                이름 : {myName}<br/>
                주소 : {myAddr}
            </div>
        </div>
    );
}

export default ThirdCmp;