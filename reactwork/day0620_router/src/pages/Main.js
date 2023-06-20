import React from 'react';
import "../App.css";
import {useNavigate} from "react-router-dom";
function Main(props) {
    //리액트 페이지 이동시 Navigate 이동해서 이동
    const navi = useNavigate();
    return (
        <div>
            <button type="button" className="mybtn"
                    onClick={() => navi("/home")}>Home 이동</button>
            <button type="button" className="mybtn"
                    onClick={() => navi("/food")}>Food1 이동</button>
            <button type="button" className="mybtn"
                    onClick={() => navi("/about")}>About1 이동</button>
            <button type="button" className="mybtn"
                    onClick={() => navi("/food/8/11")}>Food2 이동</button>
            <button type="button" className="mybtn"
                    onClick={() => navi("/about/카카오")}>About2 이동</button>

        </div>
    );
}

export default Main;