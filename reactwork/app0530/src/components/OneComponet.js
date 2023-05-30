import React, {useEffect, useState} from 'react';
import "../App.css"
function OneComponet(props) {
    const [number, setNumber] = useState(1);
    const [photo, setPhoto] = useState("1.JPG");
    const [visible, setVisible] = useState("hidden");

    //전체 자동호출
    /*useEffect(() =>{
        console.log("useEffect:전체 호출");
    });*/

    //처음 한번만 자동호출
    useEffect(() =>{
        console.log("useEffect:처음 한번만 호출");
    },[]);

    //number값 변경시에만
    useEffect(() =>{
        console.log("useEffect:number변경");
        setVisible(number%3 === 0 && number > 0?"visible":"hidden");
    },[number]);

    //photo값 변경시에만
    useEffect(() =>{
        console.log("useEffect:photo변경");
    },[photo]);

    const changePhoto = (e) => {
        setPhoto(e.target.value);
    };
    return (
        <div>
            <h2 className="alert alert-info">OneComponet</h2>
            <h1>{number}</h1>
            <button type="button" className="btn btn-info"
            onClick={()=>{
                setNumber(number-1);
            }}>감소</button>
            &nbsp;&nbsp;&nbsp;
            <button type="button" className="btn btn-info"
            onClick={()=>{
                setNumber(number+1);
            }}>증가</button>
            <hr/>
            <label>
                <input type="radio" name="photo" defaultValue={"1.JPG"} defaultChecked
                       onClick={changePhoto}/>이미지 1
            </label>
            &nbsp;
            <label>
                <input type="radio" name="photo" defaultValue={"2.JPG"}
                       onClick={changePhoto}/>이미지 2
            </label>
            &nbsp;
            <label>
                <input type="radio" name="photo" defaultValue={"3.JPG"}
                       onClick={changePhoto}/>이미지 3
            </label>
            <br/><br/>
            <img alt="" src={require(`../image/${photo}`)} width={300} style={{visibility:visible}}/>
        </div>
    );
}

export default OneComponet;