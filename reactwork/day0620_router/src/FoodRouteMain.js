import React from 'react';
import {Route, Routes} from "react-router-dom";
import FoodList from "./food/FoodList";
import FoodForm from "./food/FoodForm";
import FoodDetail from "./food/FoodDetail";

function FoodRouteMain(props) {
    return (
        <Routes>
            <Route path="/" element={<FoodList/>}/>
            <Route path="/food/list" element={<FoodList/>}/>
            <Route path="/food/form" element={<FoodForm/>}/>
            <Route path="/food/detail" element={<FoodDetail/>}/>

            <Route path="*"element={
                <div>
                    <h1>Error 404</h1>
                    <h2>잘못된 페이지 입니다.</h2>
                </div>
            }/>
        </Routes>
    );
}

export default FoodRouteMain;