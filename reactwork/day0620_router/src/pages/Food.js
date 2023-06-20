import React from 'react';
import {useParams} from "react-router-dom";

function Food(props) {
    const {food1,food2} = useParams();
    return (
        <div>
            <h3 className="alert alert-danger">Food page 입니다</h3>
            {
                food1 == null && food2 == null?<h3>오늘 점심식사를 안하겠습니다.</h3>:
                food1 != null && food2 == null?<img alt="" src={require(`../image/${food1}.jpg`)} width={200}/>:
                <div><img alt="" src={require(`../image/${food1}.jpg`)} width={200}/><br/><img alt="" src={require(`../image/${food2}.jpg`)} width={200}/></div>
            }
        </div>
    );
}

export default Food;