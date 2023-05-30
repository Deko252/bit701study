import React, {useState} from 'react';
import mycar from "../image/car9.png"

function ThreeComponet(props) {
    const [name,setName]=useState("");
    const [score,setScore]=useState(0);
    const [grade,setGrade]=useState("");
    const [tcolor,setTcolor]=useState("green");
    const [showCar, setShowCar]=useState(true);

    //redio click 이벤트
    const redioClick=(e)=>{
        setTcolor(e.target.value);
    }
    const nameInput=(e)=>{
        setName(e.target.value);
    }
    //점수입력시 적용  숫자가 아닐경우 경고
    const scoreInput=(e)=>{
        if(e.key === "Enter"){
            if(isNaN(e.target.value)){
                alert("숫자만 입력해 주세요");
                return;
            }else{
                let e_score = parseInt(e.target.value);
                setScore(parseInt(e.target.value));
                setGrade(e_score>=90?"A":e_score>=80?"B":e_score>=70?"C":e_score>=60?"D":"F");
            }
        }
    }
    const GradeChange=()=>{
        setGrade(score>=90?"A":score>=80?"B":score>=70?"C":score>=60?"D":"F");
    }

    return (
        <div>
            <h3 style={{border:"3px solid gray",backgroundColor:"#add826"}}>
                ThreeComponet 실습
            </h3>
            <h6>글자색을 선택하세요</h6>
            <div>
                <label>
                    <input type="radio" name="tcolor"
                    defaultValue={"red"}
                    onClick={redioClick}/>붉은색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type="radio" name="tcolor"
                           defaultValue={"orange"}
                           onClick={redioClick}/>어랜지색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type="radio" name="tcolor"
                           defaultValue={"blue"}
                           onClick={redioClick}/>푸른색
                </label>
                &nbsp;&nbsp;
                <label>
                    <input type="radio" name="tcolor"
                           defaultValue={"yellow"}
                           onClick={redioClick}/>누런색
                </label>
            </div>
            <div className="input-group"
            style={{marginTop:"30px",fontSize:"20px"}}>
                <b>이름 : </b>&nbsp;
                <input type="text" className="form-control"
                onChange={nameInput}/>
                &nbsp;&nbsp;
                <b>점 수</b>&nbsp;
                <input type="text" className="form-control"
                       onKeyUp={scoreInput}/>
                &nbsp;&nbsp;
                <button type="button" className="btn btn-outline-danger btn-sm"
                onClick={GradeChange}>등급 계산</button>
            </div>
            <div
                style={{marginTop:"30px",fontSize:"20px",width:"300px",textAlign:"left",marginLeft:"100px",color:tcolor}}>
                이 름 : {name}<br/>
                점 수 : {score}<br/>
                등 급 : {grade}<br/>
            </div>
            <h5>사진 보였다/숨겼다 하기</h5>
            <label>
                <input type="checkbox" defaultChecked
                onClick={(e)=> {
                    setShowCar(e.target.checked);
                }}/> 사진 보이기, 숨기기                &nbsp;
            </label>
            <br/><br/>
            {
              showCar &&
              <img alt="" src={mycar} width={300} border="10"/>
            }
        </div>
    );
}

export default ThreeComponet;