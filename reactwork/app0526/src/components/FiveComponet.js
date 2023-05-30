import React from 'react';

function FiveComponet(props) {
    const names = ["장미꽃","안개꽃","디알리아","프리지아","국화꽃"];

    //배열 출력방법 #1
    const  nameList=names.map((item,idx) =>(<li>{idx}{item}</li>));

    //배열 출력방법 #2 -- 잘 사용 안함
    const arrloop=()=>{
        let arr = [];
        for (let i=0; i<names.length; i++){
            arr.push(<h5>{names[i]}</h5>)
        }
        return arr;
    }
    return (
        <div>
            <h3 style={{border:"3px solid gray",backgroundColor:"#add826"}}>
                FiveComponet 실습
            </h3>
            {nameList}
            <hr/>
            {arrloop()}
            <hr/>
            {
                //출력방법 #3 map
                names.map((item,idx)=>(<h5>{idx}:{item}</h5>))

            }
            <hr/>
            {
                [...new Array(5)].map((item,idx) => <h5>{idx+1}</h5>)
            }
            <hr/>
            {
                [...new Array(15)].map((item,idx) => (<img alt="사진 입니다" key={idx} src={require(`../image/car${idx+1}.png`)} width={100} border={1}/>))

            }
        </div>
    );
}

export default FiveComponet;