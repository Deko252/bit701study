import React from 'react';
import "../App.css";
import {NavLink} from "react-router-dom";

function Menu(props) {
    return (
        <div>
            <ul className="menu">
                <li><NavLink to={"/"}>Main</NavLink></li>
                <li><NavLink to={"/Home"}>Home</NavLink></li>

                <li><NavLink to={"/Food"}>Food #1</NavLink></li>
                <li><NavLink to={"/Food/3"}>Food #2</NavLink></li>
                <li><NavLink to={"/Food/5/12"}>Food #3</NavLink></li>

                <li><NavLink to={"/About"}>About #1</NavLink></li>
                <li><NavLink to={"/About/Samsung"}>About #2</NavLink></li>
                <li><NavLink to={"/About/비트캠프"}>About #3</NavLink></li>
            </ul>
        </div>
    );
}

export default Menu;