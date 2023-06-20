import React from 'react';
import {NavLink, Route, Routes} from "react-router-dom";
import HomeSub1 from "./HomeSub1";
import HomeSub2 from "./HomeSub2";
import HomeSub3 from "./HomeSub3";

function Home(props) {
    return (
        <div>
            <h3 className="alert alert-success">Home page 입니다</h3>
            <br/><br/><br/><br/>
            <NavLink to="/home/sub1">Sub1</NavLink>
            &nbsp;&nbsp;
            <NavLink to="/home/sub2">Sub2</NavLink>
            &nbsp;&nbsp;
            <NavLink to="/home/sub3">Sub3</NavLink>
            <br/><br/><br/><br/>
            {/*중첩 라우터 설정*/}
            <Routes>
                <Route path="sub1" element={<HomeSub1/>}></Route>
                <Route path="sub2" element={<HomeSub2/>}></Route>
                <Route path="sub3" element={<HomeSub3/>}></Route>
            </Routes>

        </div>
    );
}

export default Home;