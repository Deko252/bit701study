import React, {useEffect, useState} from 'react';
import "./FoodStyle.css";
import {useNavigate} from "react-router-dom";
import Axios from "axios";
function FoodList(props) {
    const [foodList, setFoodList] = useState([]);

    const photoUrl1 = process.env.REACT_APP_FOODSMALLURL;
    const photoUrl2 = process.env.REACT_APP_FOODSMALLURL2;
    const navi = useNavigate();

    const handleFoodList = (search) =>{
        const listUrl="/react/list";
        Axios.get(listUrl)
            .then(res => setFoodList(res.data));
    }

    //처음 시작시 전체 메모 출력( 딱한번)
    useEffect(() => {
        handleFoodList();
    },[]);

    return (
        //JJ_Pointer_click.png?type=f&w=80&h=80&faceopt=true&ttype=jpg
        <div className="foodcontainer">
            <button type="button" className="btn btn-outline-success"
            onClick={()=>navi("/food/form")}>예약추가</button>
            <hr/>
            <h2>Food list</h2>
            <br/>
            <div style={{cursor:"pointer"}}>
                {
                    foodList.map((item, idx) =>
                        <div style={{float:"left",textAlign:"center",width:"200px",backgroundColor:"pink",marginLeft:"10px"}}>
                            <img key={idx} alt="" src={`${photoUrl1}${item.fphoto.split(',', 1)}${photoUrl2}`} className="" style={{marginTop:"15px"}}/>
                            <p>이름 : {item.fname}</p>
                            <p style={{fontSize:"12px"}}>번호 : {item.fhp}</p>
                            <p style={{fontSize:"12px"}}>하고싶은 말 : {item.fcontent}</p>
                            <p style={{fontSize:"12px"}}>예약일 : {item.bookingday}</p>
                            <p style={{fontSize:"12px"}}>예약신청일 : {item.orderday}</p>
                        </div>
                    )
                }
            </div>
        </div>
    );
}

export default FoodList;