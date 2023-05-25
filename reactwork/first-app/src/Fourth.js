import React, { useState } from "react";
import "./mystyle.css";
import {AddAlarm, AddAPhoto, DeleteForeverRounded, DeleteSharp} from "@mui/icons-material";
import InputEmojiWithRef from "react-input-emoji";
import {Button} from "@mui/material";

function Fourth(props) {
    const [number,setNumber] = useState(1);
    return (
        <div>
            <h2 className="title">안녕하세요</h2>
            <DeleteSharp/>
            <DeleteForeverRounded/>
            <AddAPhoto/>
            <AddAlarm/>
            <InputEmojiWithRef
                style={{width:"200px"}}
                laceholder="입력 하세요!"
            />
            <hr/>
            <a className="stylenum">{number}</a>
            <br/><br/>
            <Button variant="contained" color="success"
            onClick={()=>{
                if(number == 0) {
                    alert("더이상 감소할수 없습니다.")
                }else {
                    setNumber(number-1)
                }
            }}
            >
                감소
            </Button>
            &nbsp;&nbsp;
            <Button variant="contained" color="warning"
            onClick={()=>{
                if(number == 10) {
                    alert("더이상 증가할수 없습니다.")
                }else {
                    setNumber(number+1)
                }
            }}
            >
                증가
            </Button>
        </div>
    );
}

export default Fourth;