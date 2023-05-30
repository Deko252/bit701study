import React, {useRef, useState} from 'react';
import EightArrayApp from "./EightArrayApp";
import EightWriteApp from "./EightWriteApp"

function EightComponet(props) {
    const [array, setArray] = useState([
        {"name":"그루트", "blood":"AB","addr":"제주도"},
        {"name":"스타로드", "blood":"B","addr":"서울턱별시"},
        {"name":"로켓", "blood":"O","addr":"속초"}
    ]);
    //삭제함수
    const onDelete = (idx) =>{
        setArray(array.filter((ele,i) => i !== idx));
    }
    //배열에 추가하는 함수
    const addData=(data)=>setArray(array.concat(data));

    return (
        <div>
            <h2 className="alert alert-info">EightComponet</h2>
            <EightWriteApp onSave={addData}/>
            <table className="table table-bordered" style={{width:"400px"}}>
                <thead>
                    <tr style={{backgroundColor:"orange"}}>
                        <th width="60">
                            번호
                        </th>
                        <th width="160">
                            이름
                        </th>
                        <th width="160">
                            혈액형
                        </th>
                        <th width="260">
                            주소
                        </th>
                        <th width="160">삭제</th>
                    </tr>
                </thead>
                <tbody>
                {
                    array.map((ele, idx) =>
                        (<EightArrayApp key={idx} row={ele} idx={idx} onDelete={onDelete}/>))
                }
                </tbody>
            </table>
        </div>
    );
}

export default EightComponet;