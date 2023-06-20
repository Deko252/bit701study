import React from 'react';
import {BrowserRouter} from "react-router-dom";
import FoodRouteMain from "./FoodRouteMain";

function FoodRoot(props) {
    return (
        <BrowserRouter>
            <FoodRouteMain/>
        </BrowserRouter>
    );
}

export default FoodRoot;