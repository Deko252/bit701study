import React, {useState} from 'react';
import Axios from "axios";

function FiveWriteForm({onSave}) {
    const [nickname , setNickName] = useState("");
    const [korMsg ,setKorMsg] = useState("");
    const [engMsg ,setEngMsg] = useState("");

    //메세지 입력 이벤트
    const hanldeChangeMsg = (e) => {
        if(e.key === "Enter"){
            if(e.target.value === ""){
                setKorMsg("");
                setEngMsg("");
                return;
            }
            setKorMsg(e.target.value);
            const url = "/memo/trans?korMsg=" + e.target.value;
            Axios.get(url)
                .then(res=>{
                    setEngMsg(res.data.message.result.translatedText);
                })
        }

    }
    //저장버튼 이벤트
    const onSaveButtonEvent = () =>{
        if(nickname === ""){
            alert("닉네임을 입력해주세요.");
            return;
        }
        if(korMsg === ""){
            alert("메세지를 입력해주세요.");
            return;
        }
        if(engMsg === ""){
            alert("메세지를 입력 후 엔터를 눌러주세요.");
            return;
        }
        onSave({nickname:nickname,kormsg:korMsg,engmsg:engMsg});

        setNickName("");
        setEngMsg("");
        setKorMsg("");
        alert("저장 완료 !");
    }



    return (
        <div>
            <div style={{width:"500px"}}>
                <b>닉네임 :<input type="text" className="form-control"
                onChange={(e) => setNickName(e.target.value)}
                /></b>
                <button className="btn btn-outline-info" onClick={onSaveButtonEvent}>저장</button>
            </div>
            <div style={{width:"500px"}}>
                <b>메세지 : </b><input type="text" className="form-control" onChange={(e) => setKorMsg(e.target.value)} onKeyUp={hanldeChangeMsg}/>
            </div>
            <div style={{width:"500px"}}>
                <b>번역 : </b><input type="text" className="form-control" readOnly value={engMsg}/>
            </div>
        </div>
    );
}

export default FiveWriteForm;