import React, {useState} from 'react';

function TwoComponet(props) {
    const[message, setMessage]=useState("마우스 위치");

    const HandleEvent=(e)=>{
        setMessage(`마우스위치 => X좌표:${e.pageX},Y좌표:${e.pageY}`)
    }
    return (
        <div>
            <h3 style={{border:"3px solid gray",backgroundColor:"#add826"}}>
                TwoComponet 실습
            </h3>

            <div style={{width:"500ox",height:"300px",border:"1px solid black"}}
                onMouseMove={HandleEvent}>
                <h5>마우스를 움직이면 좌표가 출력됩니다.</h5>
                <br/><br/>
                <h5>{message}</h5>
            </div>

        </div>
    );
}

export default TwoComponet;