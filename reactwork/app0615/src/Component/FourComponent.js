import React, {useEffect, useState} from 'react';
import FourWriteForm from "./FourWriteForm";
import Axios from "axios";
import FourRowList from "./FourRowList";


function FourComponent(props) {
    const [list,setlist] = useState([]);

    //전체 데이터를 가져오는 함수
    const getList = () =>{
        const listUrl="/info/list";
        Axios.get(listUrl)
            .then(res => setlist(res.data));
    }
    //처음실행시 한번호출
    useEffect(()=>{
        getList();
    },[]);

    return (
        <div>
            <h2 className="alert alert-danger">Four Component</h2>
            <FourWriteForm getList={getList}/>
            <hr/>
            <h4 className="alert alert-success">총 {list.length}명의 회원이 있습니다</h4>
            {
                list.map((item,idx)=><FourRowList key={idx} item={item} getList={getList}/>)
            }
        </div>
    );

}

export default FourComponent;