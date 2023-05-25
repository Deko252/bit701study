import React from "react";
import "./mystyle.css";
import img1 from "./image/7.jpg"
const SecondCmp=()=>{
    return(
        <div>
            <h2 className="title">두번째 컴포넌트</h2>
            <h3 className="msg1">Hay Man</h3>
            <img alt="사진1" src={img1} className="poto1"/>
        </div>
    )
}

export default SecondCmp;