import React, {useEffect, useState} from 'react';
import "../App.css"
import {Delete, DeleteForever} from "@mui/icons-material";
import Swal from "sweetalert2";

function OneArrayList(props) {
    const {idx, row,onDelete} = props;
    return (
        <div className="rowStyle">
            <b>{row.irum}</b>
            &nbsp;
            <span className="day">
                {row.today.toLocaleString("ko-KR")}
                &nbsp;
                {/*<Delete style={{cursor:"pointer"}}
                        onClick={() =>
                            onDelete(idx)
                        }/>*/}
                {/* 삭제할까요 물어본후 예 클릭시 삭제하기-confirm 대신 aweetalert2*/}
                {/* https://inpa.tistory.com/entry/SweetAlert2-%F0%9F%93%9A-%EC%84%A4%EC%B9%98-%EC%82%AC%EC%9A%A9 */}
                <DeleteForever style={{cursor:"pointer"}} onClick={() => {
                    Swal.fire({
                        title:"삭제 확인",
                        text:"해당 방명록을 삭제 하시겠습니까?",
                        icon:"warning",
                        confirmButtonColor:"#3085d6",
                        confirmButtonText:"예",
                        showCancelButton:true,
                        cancelButtonColor:"#ccc",
                        cancelButtonText:"취소"
                    }).then((result)=>{
                        if(result.isConfirmed){
                            //삭제함수 호출
                            onDelete(idx);
                            Swal.fire("삭제했습니다.");
                        }else{
                            Swal.fire("취소했습니다.");
                        }
                    })
                }}
                />
            </span>
            <br/><br/>
            <h5><b>{row.message}</b></h5>
        </div>
    );
}

export default OneArrayList;