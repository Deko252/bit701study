import React, {useState} from 'react';
import {DeleteForeverRounded} from "@mui/icons-material";

function FiveRowList({memo, onDelete}) {
    return (
        <div className="memolist">
            <div>
                닉네임 : {memo.nickname}
                <span style={{float:"right", fontSize:"0.7em", color:"gray"}}>작성일 : {memo.writeday}</span>
            </div>
            <b>메세지 : {memo.kormsg}</b><br/>
            <b style={{color:"orange", fontWeight:"bold"}}>번역 : {memo.engmsg}</b>
            <DeleteForeverRounded style={{marginLeft:"350px",color:"red",cursor:"pointer"}} onClick={() => {
                let b = window.confirm("삭제 하시겠습니까?");
                if(!b) {
                    return;
                }else {
                    onDelete(memo.num);
                }
            }}/>
            <br/>
        </div>
    );
}

export default FiveRowList;