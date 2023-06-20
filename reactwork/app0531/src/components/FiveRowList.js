import React, {useState} from 'react';
function FiveRowList(props) {
    const {row, idx,onDelete,handleClickOpen} = props;


    return (
            <tr>
                <td align="center">{idx+1}</td>
                <td align="left" style={{cursor:"pointer"}} onClick={()=>handleClickOpen(row)}>
                    {row.subject}
                </td>
                <td>{row.writer}</td>
                <td>{row.today.toLocaleString("ko-KR")}</td>
                <td>
                <button className="btn btn-outline-danger" type="button" onClick={() =>
                    onDelete(idx)
                }>삭제</button>
                </td>
            </tr>
    );
}

export default FiveRowList;