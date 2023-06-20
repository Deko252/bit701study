import React, {useEffect, useState} from 'react';
import {Button} from "@mui/material";
import Swal from "sweetalert2";
import xmas1 from "../image/xmas/candle2.gif";
import xmas2 from "../image/xmas/tree3.gif";
import xmas3 from "../image/xmas/house1.gif";
import image123 from "../image/xmas/123.jpg";
function TwoComponet(props) {
    const buttonEvent1 = () => {
        /*Swal.fire("안녕하세요");*/
        Swal.fire("아침문안","안녕하세요");
    }
    const buttonEvent2 = () => {
        Swal.fire({
            title:"사진 넣기",
            html:"<h5>이게 무슨 이미지 ?</h5>",
            imageUrl:image123 /*src의 사진 -import된*/
        })
    }
    const buttonEvent3 = () => {
        Swal.fire({
            html:
                `<b style="color:red">오늘은 내가 요리사</b>
                <h5>메리메리 크리스마스</h5>
                `,
            imageUrl:"../a5.gif",/*public 이미지*?*/
            icon:"success",
            confirmButtonText:"YASSS!!!",
            confirmButtonColor:"#abcabc",
            showCancelButton:true,
            cancelButtonText:"NOPE!!!!!",
            cancelButtonColor:"cbacba"
        }).then((r) =>{
            if(r.isConfirmed){
                Swal.fire("실행 합니다");
            }else{
                Swal.fire("취소 합니다.")
            }
        })
    }
    const buttonEvent4 = () => {
        Swal.fire({
            title:"Input Email Address",
            input:"email",
            inputLabel:"Your email Address",
            inputPlaceholder:"Enter Your email address"
        }).then((result)=>{
            Swal.fire(`당신의 이메일주소는 ${result.value}`);
        })
    }
    const buttonEvent5 = () => {
        let arr =[{photo:xmas1, likesid:"angel"},
            {photo:xmas2, likesid:"bit"},{photo:xmas3, likesid:"camp"},
        ];

        let s = "";
        for (let m of arr){
            s += `<img alt="" src=${m.photo} width=60/> &nbsp;<b>${m.likesid}</b><br/>`;
        }
        Swal.fire({
            title:"좋아요 누른 회원들",
            imageUrl:image123,
            html:s
        })
    }

    return (
        <div>
            <h2 className="alert alert-info">두번째 입니다.</h2>
            <Button variant="contained" color="warning" onClick={buttonEvent1}>Sweet Alert연습 #1</Button>
            <br/><br/>
            <Button variant="contained" color="error" onClick={buttonEvent2}>Sweet Alert연습 #2</Button>
            <br/><br/>
            <Button variant="contained" color="success" onClick={buttonEvent3}>Sweet Alert연습 #3</Button>
            <br/><br/>
            <Button variant="contained" color="primary" onClick={buttonEvent4}>Sweet Alert연습 #4</Button>
            <br/><br/>
            <Button variant="outlined" color="info" onClick={buttonEvent5}>Sweet Alert연습 #5</Button>

        </div>
    );
}

export default TwoComponet;