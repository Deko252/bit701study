import React, {useEffect, useState} from 'react';

function TwoComponet(props) {
    const [nameArray,setNameArray] = useState(["캔디","사탕","아이스크림"]);
    const [name, setname] = useState("");

    useEffect(()=>{
        setname("");
    },[nameArray]);
    //이름을 배열에 추가하는 함수
    const addName = () =>{
        //set 메서드를 연속해서 호출할경우 순차적으로 실행이 안될수도 있다
        //그런 경우 반드시 nameArray 가 변경된후 name 이 변경되도록 하려면
        //name은 useEffact를 이용해서 변경하면 된다.
        setNameArray(nameArray.concat(name));
        //setname("");
    }
    const deleteName = (idx) =>{
        setNameArray(nameArray.filter((item,i) => i !== idx));
    }
    return (
        <div>
            <h2 className="alert alert-info">TwoComponet</h2>
            <div className="input-group" style={{width:"350px"}}>
                <h4 className="alert alert-info">이름 입력</h4>
                <input type="text" className="form-control" value={name}
                       onChange={(e)=>{
                                    setname(e.target.value);
                        }}
                />
                <button type="button" className="btn btn-sm btn-outline-danger"
                    onClick={addName}
                >추가</button>
            </div>
            <hr/>
            {
                nameArray.map((item,idx) =>(
                    <div className="input-group" style={{width:"300px",marginBottom:"10px",fontFamily:"Jua"}}
                        key={idx}>
                        <h4 style={{width:"200px"}}>{item}</h4>
                        <button type="button" className="btn btn-outline-danger"
                        onClick={() => {
                            deleteName(idx);
                        }}>삭제</button>

                    </div>
                ))
            }
        </div>
    );
}

export default TwoComponet;