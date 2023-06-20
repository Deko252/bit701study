import React, {useState} from 'react';

function ThreeSubApp(props) {
    const [photo,setPhoto] = useState("");
    const [photoName, setPhotoName] = useState("");

    const onChangePhoto = (e) =>{
        let photos = (e.target.value);
        /*alert(e.target.value);*/
        let PhotoNames = (e.target.options[e.target.selectedIndex].text);
        /*alert(e.target.options[e.target.selectedIndex].text);*/
        props.onChangePhoto(photos,PhotoNames);
    }

    return (
        <div style={{width:"200px",marginLeft:"100px"}}>
            <select className="form-select" onChange={onChangePhoto}>
                <option value={"tree3.gif"}>크리스마스 트리</option>
                <option value={"xmas01.gif"}>눈사람</option>
                <option value={"santa.gif"}>산타클로스</option>
                <option value={"house1.gif"}>집</option>
                <option value={"flogirl.gif"}>소녀</option>
            </select>
        </div>
    );
}

export default ThreeSubApp;