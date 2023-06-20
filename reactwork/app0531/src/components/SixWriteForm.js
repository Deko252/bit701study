import React, {useState} from 'react';

function SixWriteForm(props) {
    const [data,setData] = useState({irum:"",blood:"",hp:""});

    const changeEvent = (e) =>{
        let {name,value} = e.target;

        //입력한 항목만 변경
        setData({
            ...data,//나머지는 그대로 유지
            [name]:value
        })
    }

    return (
        <div>
            <div>
                이름:{data.irum}, 혈액형{data.blood}, 핸드폰:{data.hp}
            </div>
            이름 : <input type="text" name="irum" size={5} onChange={changeEvent}/>
            &nbsp;&nbsp;
            혈액형 : <input type="text" name="blood" size={5} onChange={changeEvent}/>
            &nbsp;&nbsp;
            번호 : <input type="text" name="hp" size={5} onChange={changeEvent}/>
            &nbsp;&nbsp;
            <button type="button" onClick={()=>{addData(data)}}>추가</button>
        </div>
    );
}

export default SixWriteForm;