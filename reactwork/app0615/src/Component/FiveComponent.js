import React, {useEffect, useState} from 'react';
import FiveRowList from "./FiveRowList";
import FiveWriteForm from "./FiveWriteForm";
import Axios from "axios";

function FiveComponent(props) {
    const [memoList, setMemoList] = useState([]);
    const [search, setSearch] = useState("");

    //출력이벤트
    const handleMemoList = (search) =>{
        const listUrl="/memo/list?search=" + search;
        Axios.get(listUrl)
            .then(res => setMemoList(res.data));
    }

    //처음 시작시 전체 메모 출력( 딱한번)
    useEffect(() => {
        handleMemoList(search);
    },[]);

    //저장 이벤트
    const handleSaveMemo = (memo) => {
        Axios.post("/memo/insert" , memo)
            .then(res => {
                handleMemoList(search);
            })
    }

    //삭제 이벤트
    const handleDeleteMemo = (num) => {
        const url="/memo/delete?num=" + num;
        Axios.delete(url)
            .then(res=>{
                //삭제후 다시 출력
                handleMemoList();
            })
    }
    return (
        <div>
            <h2 className="alert alert-info">FiveComponent - Memo</h2>
            <FiveWriteForm onSave={handleSaveMemo}/>
            <hr/>
            검색 : <input type="text" placeholder="입력하세요" value={search} onChange={(e) =>{
                setSearch(e.target.value)
                {handleMemoList(e.target.value)}
        }}/><br/><br/>
            <h4 className="alert alert-success">총 {memoList.length}개의 메모가 있습니다</h4>
            {
                memoList.map((memo,idx) => <FiveRowList key={idx} memo={memo} onDelete={handleDeleteMemo}/>)
            }
            <br/>
        </div>
    );
}

export default FiveComponent;