import React, { useState } from 'react';
import Axios from 'axios';

function FourWriteForm({getList}) {
    const [data,setData]=useState({
        num:0,
        irum:"noname",
        address:"no address",
        birthday:"no birth"
    });

    const [photo,setPhoto]=useState('');

    const photoUrl="https://kr.object.ncloudstorage.com/bit701-bucket-114/react/";

    //저장 버튼 이벤트
    const saveButtonEvent=()=>{
        let url="/info/insert";
        Axios.post(url,data)
            .then(res=>{
                setData(res.data);
                //목록 다시 출력
                getList();
            })
    }

    //사진변경 버튼 이벤트
    const changePhotoEvent=(e)=>{
        let url="/info/photo";
        const imageFile=new FormData();
        imageFile.append("upload",e.target.files[0]);
        imageFile.append("num",data.num);

        Axios({
            method:'post',
            url:url,
            data:imageFile,
            headers:{'Content-Type':'multipart/form-data'}
        }).then(res=> {
            setPhoto(res.data);
            //목록 다시 출력
            getList();
        });//반환된 버켓에 저장된 이름을 photo 에 넣는다
    }
    return (
        <div>
            <h4>Info 데이타 입력</h4>
            <div className='input-group' style={{width:'600px'}}>
                <b>이름</b>&nbsp;
                <input type='text' className='form-control' value={data.irum}
                       onChange={(e)=>{
                           setData({
                               ...data,
                               irum:e.target.value
                           })
                       }}/>&nbsp;&nbsp;
                <b>주소</b>&nbsp;
                <input type='text' className='form-control'  value={data.address} onChange={(e)=>{
                    setData({
                        ...data,
                        address:e.target.value
                    })
                }}/>&nbsp;&nbsp;
                <b>생년월일</b>&nbsp;
                <input type='date' className='form-control'  value={data.birthday} onChange={(e)=>{
                    setData({
                        ...data,
                        birthday:e.target.value
                    })
                }}/>&nbsp;&nbsp;
                <button type='button'  className='btn btn-sm btn-outline-info'
                        onClick={saveButtonEvent}>저장</button>
            </div>
            <h3 className='alert alert-warning'>
                값확인:{data.num}/{data.irum}/{data.address}/{data.birthday}
            </h3>
            <h4>사진은 데이타를 먼저 저장후 변경해주세요</h4>
            <input type='file' onChange={changePhotoEvent}/>
            <br/>
            <img alt='' style={{width:'100px',border:'2px solid gray'}}
                 src={photoUrl+photo} align="left"/>

            <button type="button" className="btn btn-danger"
            style={{width:"100px",height:"100px"}} onClick={()=>{
                setData({num:0,irum: "",address: "",birthday: ""});
                setPhoto("");
            }}>초기화</button>
        </div>
    );
}
export default FourWriteForm;