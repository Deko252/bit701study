import React, {useState, useRef} from 'react';
import ThreeSubApp from "./ThreeSubApp";
function ThreeComponet(props) {
    const [data , setData] = useState({
        photo:"tree3.gif",
        photoName:"크리스마스 트리"
    });
    const onChangePhoto = (photo,photoName) =>{
        setData(({
            photo,
            photoName
        }));
    }
    return (
        <div>
            <h2 className="alert alert-info">세번째입니다.</h2>
            <ThreeSubApp onChangePhoto={onChangePhoto}/>
            <hr/>
            <h3><b>{data.photoName}</b></h3>
            <br/><br/>
            <img alt="사진" src={require(`../image/xmas/${data.photo}`)} style={{maxWidth:"300px"}}/>
        </div>
    );
}

export default ThreeComponet;