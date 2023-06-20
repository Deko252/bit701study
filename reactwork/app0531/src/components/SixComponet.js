import React, {useRef, useState} from 'react';
import SixWriteForm from "./SixWriteForm";
import SixRowitem from "./SixRowitem";
function SixComponet(props) {
    const [data,setData] = useState([
        {"irum":"JJ","blood":"J","hp":"010-2345-6789"},
        {"irum":"YJ","blood":"Y","hp":"010-6789-2345"}
    ]);
    //데이터 추가
    const addDataEvent = (item) =>{
        setData(data.concat(item));
    }

    return (
        <div>
            <h2 className="alert alert-info">Six Component - 복습문제</h2>
            <SixWriteForm addData={addDataEvent}/>
            <hr/>
            <h5>{data.length}명 등록</h5>
            {
                data.map((ele,idx) => <SixRowitem key={idx} idx={idx} ele={ele}/>)
            }
        </div>
    );
}

export default SixComponet;