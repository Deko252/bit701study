import React, {useRef, useState} from 'react';

function SevenChildApp2(props) {
    const {photoname,photoprice,photo} = props;
    return (
        <div>
            <h5 className="alert alert-danger" style={{border:"3px soid pink",fontFamily:"Jua",marginBottom:"10px"}}>Seven의 자식 컴포넌트 번째
                과제 이름 : {photoname} 과제 가격 : {photoprice}
            </h5>
            <br/>
            <div>
                <img alt={photoname} src={require(`../image/${photo}`)} style={{width:"300px"}}/>
            </div>
        </div>
    );
}

export default SevenChildApp2;