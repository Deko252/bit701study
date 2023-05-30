import React, {useState} from 'react';
import "../App.css";

function MunjeComponet(props) {
    const [showPhoto, setShowPhoto] = useState(true);
    const [photoIdx, setPhotoIdx] = useState(0);
    const [borderST, setBorder] = useState("3px solid red");
    const [photoSize , setPhotoSize] = useState(200);
    const [inputText, setInputText] = useState("리액트 입니다.");
    const array1 =[
        {"showphotos":"4.jpg","photoname":"사진1"},
        {"showphotos":"5.jpg","photoname":"사진2"},
        {"showphotos":"7.jpg","photoname":"사진3"}
    ];
    const changePhoto  = (e) => {
        setPhotoIdx(parseInt(e.target.value));
    }
    const changeBorder = (e) => {
        setBorder(e.target.value);
    }
    const changeSizeSmall = () => {
        setPhotoSize(photoSize-10);
    }
    const changeSizeBig = () => {
        setPhotoSize(photoSize+10);
    }
    const ShowPhoto = (e) =>{
        setShowPhoto(e.target.checked===true?false:true);
    }
    const InputText = (e) => {
        setInputText(e.target.value);
    }

    return (
        <div>
            <h3 style={{border:"3px solid gray",backgroundColor:"#add826"}}>
                MunjeComponet 실습
            </h3>
            <br/>
            <label>
                <input type="checkbox" onClick={ShowPhoto}/>사진 숨기기
            </label>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button type="button" className="btn btn-outline-danger btn-sm" onClick={changeSizeSmall}>점점 작게</button>
            &nbsp;
            <button type="button" className="btn btn-outline-danger btn-sm" onClick={changeSizeBig}>점점 크게</button>
            <br/>
            <input type="text" value={inputText} onChange={InputText} style={{width:"300px"}}/>
            <br/><br/>
            <div>
                <div style={{display:"inline-block"}}>
                    <select onChange={changePhoto}>
                                <option value={0}>{array1[0].photoname}</option>
                                <option value={1}>{array1[1].photoname}</option>
                                <option value={2}>{array1[2].photoname}</option>

                    </select>
                    <br/>
                    <br/>
                    <select onClick={changeBorder}>
                        <option value="3px solid red">solid</option>
                        <option value="7px dotted red">dotted</option>
                        <option value="5px double red">double</option>
                    </select>
                </div>
                &nbsp;&nbsp;&nbsp;&nbsp;
                {
                    showPhoto    &&
                <div  style={{display:"inline-block",border:borderST}}>
                        <img alt="사진자리" src={require(`../image/${array1[photoIdx].showphotos}`)} style={{width:photoSize,height:photoSize}}/>
                </div>
                }
            </div>
            <br/>
            <input type="text" readOnly value={inputText} style={{width:"400px",height:"100px"}}/>
            <br/>
            <div>
                사진모음
                <br/>
                {
                    array1.map(
                        (item, idx) =>
                            ( idx === photoIdx ?<figure key={idx} className="photo"><img style={{width:"150px"}} alt={item.photoname} src={require(`../image/${item.showphotos}`)}/>
                                <figcaption>{item.photoname}<br/>제 idx 는 {idx}에요 {photoIdx}라서 나와요</figcaption></figure>:<div>제 idx 는 {idx}에요 {photoIdx}가 아니라서 안나와요 </div>
                            )

                    )
                }

            </div>
        </div>
    );
}

export default MunjeComponet;