import React, {useEffect, useState} from 'react';
import "../App.css"
import OneArrayList from "./OneArrayList";
import OneWriteForm from "./OneWriteForm";
function OneComponet(props) {
    const [list,setList] = useState([
        {irum:"사탕",message:"냠냠",today:new Date()},
        {irum:"라면",message:"쩝쩝",today:new Date()}
    ]);

    //추가 이벤트
    const addListHandler=(data)=>{
        setList(list.concat({
            ...data,
            today: new Date()
        }));
    }
    const onDelete = (idx) =>{
        setList(list.filter((d,i) => i !== idx));
    }
    return (
        <div>
            <h2 className="alert alert-info">간단한 방명록</h2>
            <OneWriteForm onSave={addListHandler}/>
            <hr/>
            {
                list.map((ele,idx) => <OneArrayList key={idx} idx={idx} row={ele} onDelete={onDelete}/>)
            }
        </div>
    );
}

export default OneComponet;