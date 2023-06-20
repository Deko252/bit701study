import React, {useRef, useState} from 'react';
import "./FoodStyle.css";
import {useNavigate} from "react-router-dom";
import {CameraAltOutlined} from "@mui/icons-material";
import Axios from "axios";
function FoodForm(props) {
    const [foodPhoto, setFoodPhoto] = useState([]);
    const [fname,setFname] = useState("");
    const [fhp,setFhp] = useState("");
    const [bookingday, setBookingday] = useState("");

    const contentRef = useRef();

    const photoUrl1 = process.env.REACT_APP_FOODSMALLURL;
    const photoUrl2 = process.env.REACT_APP_FOODSMALLURL2;
    const navi = useNavigate();
    //파일 업로드 이벤트
    const fileUploadEvent = (e) =>{
        //파일 갯수가 3개가 넘을 경우 이벤트 종료
        if(e.target.length > 3){
            alert("파일을 3개까지만 업로드 가능합니다");
            return;
        }

        const upload = new FormData();
        for(let i=0; i<e.target.files.length; i++ ){
            upload.append("upload",e.target.files[i]);
        }
        
        //스프링 서버로 보내고 업로드된 파일명 리턴 받기
        Axios({
            method:"post",
            url:"/react/upload",
            data:upload,
            headers:{"Contnet-Type":"multipart/form-data"}
        }).then(res =>{
            setFoodPhoto(res.data);
        })
    }

    //submit 이벤트 발생시 호출 함수
    const onSubmitEvent = (e) =>{
        //기본 이벤트를  무효화 (action 호출 막기)
        e.preventDefault();
        if(foodPhoto.length===0){
            alert("사진을 먼저 업로드 해주세요");
            return;
        }
        //하고싶은 말
        const fcontent = contentRef.current.value;
        //서버에 보내기
        Axios.post("/react/insert",{fname,fhp,fcontent,bookingday})
            .then(res =>{
                //목록 페이지로 이동
                navi("/food/list");
            })
    }
    return (
        <div className="foodcontainer">
            <button type="button" className="btn btn-outline-danger"
                    onClick={()=>navi("/food/list")}>목록으로</button>
            <hr/>
            <h2>Food Form</h2>
            <input type="file" style={{display:"none"}} id="file" multiple
            onChange={fileUploadEvent}/>
            <CameraAltOutlined Style={{fontSize:"30px",cursor:"pointer"}}
            onClick={()=>document.getElementById("file").click()}
            />
            <br/>
            <h5>업로드한 사진 미리보기</h5>
            <div>
                {
                    foodPhoto.map((photo,idx) =>
                        <img key={idx} alt="" src={`${photoUrl1}${photo}${photoUrl2}`}
                        style={{border:"2px solid pink", borderRadius:"30px",marginRight:"10px"}}/>)
                }
            </div>
            <br/>

            <form onSubmit={onSubmitEvent}>
                <table className="table" style={{width:"400px"}}>
                    <tr>
                        <th style={{width:"150px",backgroundColor:"#ddd"}}>예약자 이름</th>
                        <td>
                            <input type="text" className="form-control"
                            onChange={(e) => setFname(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width:"150px",backgroundColor:"#ddd"}}>핸드폰</th>
                        <td>
                            <input type="text" className="form-control"
                                   onChange={(e) => setFhp(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width:"150px",backgroundColor:"#ddd"}}>예약날짜</th>
                        <td>
                            <input type="text" className="form-control"
                                   onChange={(e) => setBookingday(e.target.value)}/>
                        </td>
                    </tr>
                    <tr>
                        <th style={{width:"150px",backgroundColor:"#ddd"}}>하고싶은 말</th>
                        <td>
                           <textarea ref={contentRef} className="form-cntrol"
                           style={{width:"100%",height:"100px"}}></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} align="center">
                            <button type="submit" className="btn btn-outline-danger">DB저장</button>
                            <button type="reset" className="btn btn-outline-danger"
                            style={{marginLeft:"10px"}}>초기화</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    );
}

export default FoodForm;