import React, {useEffect, useState} from 'react';
import "../App.css"
import {TextField, Button} from "@mui/material";
import InputEmojiWithRef from "react-input-emoji";
function OneWriteForm({onSave}) {
    const [irum,setIrum]=useState("");
    const [message, setMessage] = useState("");
    const handlOnEnter = (text) => {
        setMessage(text);
        console.log("message" + message);
    }

    return (
        <div>
            <TextField
                required
                id="outlined-required"
                lable="Nickname"
                value={irum}
                onChange={(e)=>
                    setIrum(e.target.value)
            }
            />
            &nbsp;&nbsp;
            <Button variant="contained" size="large"
                onClick={()=>{
                    if(irum === "") {
                        alert("닉네임을 입력해 주세요");
                        return;
                    }
                    
                    if(message === "") {
                        alert("메세지를 입력해 주세요");
                        return;
                    }
                    //부모 컴포넌트로 입력데이터를 보낸다.
                    onSave({irum,message});
                    setIrum("");
                }}>
                등록
            </Button>
            <InputEmojiWithRef
                cleanOnEnter
                onEnter={handlOnEnter}
                placeholder="Type a message"
            />

        </div>
    );
}

export default OneWriteForm;