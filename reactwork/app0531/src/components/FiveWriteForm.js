import React, {useState} from 'react';

function FiveWriteForm(props) {
    const [writer,setWriter] = useState("");
    const [subject, setSubject] = useState("");
    const [content, setContent] = useState("");
    const [photo, setPhoto] = useState("flogirl.gif");
    const buttonAddEvent = () =>{
        props.addBoard({writer,subject,content,photo});
    }
    return (
        <div>
            작성자 : <input type="text" onChange={(e) => setWriter(e.target.value)}/>
            <br/>
            제목 : <input type="text"  onChange={(e) => setSubject(e.target.value)}/>
            <br/>
            사진 :
            <select style={{width:"170px"}}  onChange={(e) => setPhoto(e.target.value)}>
                <option value={"flogirl.gif"}>소녀</option>
                <option value={"asman.gif"}>스 ~ 노우맨</option>
                <option value={"a7.gif"}>곰</option>
                <option value={"house5.gif"}>니가 사는 그 집</option>
                <option value={"candle1.gif"}>양초</option>
            </select><br/>
            <textarea style={{width:"480px",height:"130px"}} onChange={(e) => setContent(e.target.value)}></textarea>
            <br/>
            <button type="button" onClick={buttonAddEvent}>게시글 등록</button>
        </div>
    );
}

export default FiveWriteForm;