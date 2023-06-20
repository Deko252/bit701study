import React, {useRef, useState} from 'react';
import FourWriteForm from "./FourWriteForm";
import noimage from "../noimage.jpg";
import "../App.css";
import DeleteIcon from "@mui/icons-material/Delete";
import PhotoCameraIcon from '@mui/icons-material/PhotoCamera';
import Axios from "axios";
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import {Edit} from "@mui/icons-material";
function FourRowList({item, getList}) {
    const [updateData,setUpdateData] = useState({
        num:item.num,
        irum:item.irum,
        address:item.address,
        birthday:item.birthday
    });
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };

    //수정버튼 이벤트
    const handleUpdates = () => {
        setOpen(false);

        Axios.post("/info/update", updateData)
            .then(res=>{
                //수정후 목록 다시 호출
                getList();
            })
    };
    const handleDelete = (num) =>{
        let url = `/info/delete/${item.num}` //방법2
        Axios.delete(url)
            .then(res=>{
                getList();
            })
            .catch(err=>alert(err));

    }
    const [photo , setPhoto] = useState("");
    const handleUpdate = (e) =>{
        let url = `/info/photo/`
        const imageFile=new FormData();
        imageFile.append("upload",e.target.files[0]);
        imageFile.append("num",`${item.num}`);

        Axios({
          method:"post",
          url:url,
          data:imageFile,
          headers:{'Content-Type':'multipart/form-data'}
        }).then(res => {
           setPhoto(res.data);
            getList();
        });

    }
    const file = useRef();

    const photoUrl="https://kr.object.ncloudstorage.com/bit701-bucket-114/react/";
    //.env
    //const photoUrl = process.env.REACT_APP_PHOTOURL;


    return (
        <div className="rowstyle" style={{textAlign:"center"}}>
            <img src={item.photo === null?noimage:photoUrl + item.photo} alt=""/>
            <br/>
            이름 : {item.irum}<br/>
            주소 : {item.address}<br/>
            생년월일 : {item.birthday}<br/>
            가입일 : {item.gaipday}<br/>
            <b style={{cursor:"pointer"}}><PhotoCameraIcon onClick={()=>{
                file.current.click();
            }}/>
                <input type="file" ref={file} style={{display:"none"}} onChange={handleUpdate}/>
            </b>
            &nbsp;&nbsp;
            <b style={{cursor:"pointer"}} onClick={handleDelete}>
            <input type="hidden" value={item.num} name="hiNum"/>
                <DeleteIcon/>
            </b>
            &nbsp;&nbsp;
            <Edit style={{fontSize:"14px",cursor:"pointer"}} onClick={handleClickOpen}/>
            <Dialog
                open={open}
                onClose={handleClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">
                    {"Use Google's location service?"}
                </DialogTitle>
                <DialogContent>
                    {<DialogContentText id="alert-dialog-description">
                        <input type="text" value={updateData.irum} onChange={(e) => setUpdateData({
                            ...updateData,
                            irum:e.target.value
                        })}/>
                        <br/>
                        <input type="text" value={updateData.address} onChange={(e) => setUpdateData({
                            ...updateData,
                            address:e.target.value
                        })}/>
                        <br/>
                        <input type="text" value={updateData.birthday} onChange={(e) => setUpdateData({
                            ...updateData,
                            birthday:e.target.value
                        })}/>
                    </DialogContentText>}
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>취소</Button>
                    <Button onClick={handleUpdates} autoFocus>
                        수정
                    </Button>
                </DialogActions>
            </Dialog>
         </div>
    );
}

export default FourRowList;