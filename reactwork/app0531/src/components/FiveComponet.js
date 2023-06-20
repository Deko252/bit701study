import React, {useRef, useState} from 'react';
import FiveRowList from "./FiveRowList";
import FiveWriteForm from "./FiveWriteForm";
//여기부터 복붙
import Button from '@mui/material/Button';
import { styled } from '@mui/material/styles';
import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import DialogContent from '@mui/material/DialogContent';
import DialogActions from '@mui/material/DialogActions';
import IconButton from '@mui/material/IconButton';
import CloseIcon from '@mui/icons-material/Close';
import Typography from '@mui/material/Typography';

const BootstrapDialog = styled(Dialog)(({ theme }) => ({
    '& .MuiDialogContent-root': {
        padding: theme.spacing(2),
    },
    '& .MuiDialogActions-root': {
        padding: theme.spacing(1),
    },
}));

export interface DialogTitleProps {
    id: string;
    children?: React.ReactNode;
    onClose: () => void;
}

function BootstrapDialogTitle(props: DialogTitleProps) {
    const { children, onClose, ...other } = props;

    return (
        <DialogTitle sx={{ m: 0, p: 2 }} {...other}>
            {children}
            {onClose ? (
                <IconButton
                    aria-label="close"
                    onClick={onClose}
                    sx={{
                        position: 'absolute',
                        right: 8,
                        top: 8,
                        color: (theme) => theme.palette.grey[500],
                    }}
                >
                    <CloseIcon />
                </IconButton>
            ) : null}
        </DialogTitle>
    );
}
//일단 여기까지
function FiveComponet(props) {
    const [dataList, setDataList] = useState([
        {writer:"킬러조",subject:"간드아!!!!!",content:"잘가라",photo:"bell2.gif",today:new Date()},
        {writer:"JJ",subject:"무소식이 ? 희소식이다.",content:"요호호호호",photo:"tree5.gif",today:new Date()}
    ]);

    //게시글 추가 이벤트
    const addBoard = (item) =>{
        setDataList(dataList.concat({
            ...item,
            today:new Date()
        }))
    }
    const onDelete = (idx) =>{
        setDataList(dataList.filter((d,i) => i !== idx));
    }
    //여기 부터 mui
    const [selectData,setSelectData]=useState(
        {
            writer:'',
            subject:'',
            content:'',
            photo:'a1.gif',
            today:new Date()
        });
    const [open, setOpen] = React.useState(false);

    const handleClickOpen = (data) => {
        setSelectData(data);
        setOpen(true);
    };
    const handleClose = () => {
        setOpen(false);
    };
    //여기까지

    return (
        <div>
            <h2 className="alert alert-info">다섯번째입니다.</h2>
            <FiveWriteForm addBoard={addBoard}/>
            <hr/>
            <table className="table table-bordered" style={{width:"700px"}}>
                <thead>
                    <tr style={{backgroundColor:"orange"}}>
                        <th style={{width:"60px"}}>번호</th>
                        <th style={{width:"300px"}}>제목</th>
                        <th style={{width:"100px"}}>작성자</th>
                        <th style={{width:"100px"}}>작성일</th>
                        <th style={{width:"100px"}}>삭제</th>
                    </tr>
                </thead>
                <tbody>
            {
                dataList.map((item, idx) => (
                  <FiveRowList key={idx} row={item} idx={idx} onDelete={onDelete} handleClickOpen={handleClickOpen}/>
                ))
            }
                </tbody>
            </table>
            {/*mui 다이얼 로그*/}
            <BootstrapDialog
                onClose={handleClose}
                aria-labelledby="customized-dialog-title"
                open={open}
            >
                <BootstrapDialogTitle id="customized-dialog-title" onClose={handleClose} style={{width:"500px"}}>
                    {selectData.subject}
                </BootstrapDialogTitle>
                <DialogContent dividers>
                    <Typography gutterBottom>
                        <div style={{textAlign:"right"}}>작성자 : {selectData.writer}</div>
                        <div style={{textAlign:"right"}}>작성일 : {selectData.today.toLocaleString('ko-KR')}</div>
                    </Typography>
                    <Typography gutterBottom>
                        <div style={{textAlign:"center"}}><img alt="사진자리" src={require(`../image/xmas/${selectData.photo}`)} width={"300px"}/></div>
                    </Typography>
                    <Typography gutterBottom>
                        <div style={{textAlign:"center"}}>{selectData.content}</div>
                    </Typography>
                </DialogContent>
                <DialogActions>
                    <Button autoFocus onClick={handleClose}>
                        Save changes
                    </Button>
                </DialogActions>
            </BootstrapDialog>
        </div>
    );
}

export default FiveComponet;