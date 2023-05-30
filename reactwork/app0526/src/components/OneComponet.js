import React, {useState} from 'react';
import "../App.css"
import car1 from "../image/car3.png"
function OneComponet(props) {
    const [carName1,setCarName1]=useState("골드");
    const [carName2, setcarName2]=useState("실버");
    //출력은 가능하지만 수정은 할 수 없다
    let message = "Have a Hover Day"
    return (
        <div>
            <h3 style={{border:"3px solid gray",backgroundColor:"#add826"}}>
                OneComponet 실습
            </h3>
            <h5 className="one two">
                {message}
            </h5>
            <img alt="자동차3번" src={car1} width={200}/>
            <b>{carName1}</b>
            <br/>
            <h5>reqire를 이용해서 src 이미지 가져오기</h5>
            <img alt="" src={require(`../image/car11.png`)} width={200}/>
            <b>{carName2}</b>
            <hr/>
            <div className="input-group">
                <input type="text" className="form-control"
                placeholder="천번째 차 이름"
                    onKeyUp={(e)=>{
                    setCarName1(e.target.value);
                    }}
                />
                <input type="text" className="form-control"
                placeholder="두번째 차 이름(엔터)"
                    onKeyUp={(e)=>{
                        if(e.key === "Enter"){
                            setcarName2(e.target.value)
                        }
                    }}
                />
            </div>
        </div>
    );
}

export default OneComponet;