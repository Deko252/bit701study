import React from 'react';
import "../App.css";


function SixComponet(props) {
    const array1=["red","green","blue","orange","gray","pink","white","yellow"];
    const array2 =[
        {"carphoto":"car3.png","carname":"유자차","carprice":"9억2천만"},
        {"carphoto":"car7.png","carname":"영차","carprice":"200원"},
        {"carphoto":"car11.png","carname":"녹차","carprice":"3000만"},
        {"carphoto":"car8.png","carname":"으라차차","carprice":"29억8천만"},
        {"carphoto":"car5.png","carname":"율무차","carprice":"1600억"}
    ];
    return (
        <div>
            <h3 style={{border:"3px solid gray",backgroundColor:"#add826"}}>
                SixComponet 실습
            </h3>
            <div>
                <h6>
                    array1 배열 출력하기<br/>
                    {
                        array1.map(
                                    (color,idx) =>
                                    (<div key={idx} style={{backgroundColor:color}} className="circle">{idx}</div>)
                        )
                    }
                </h6>
                <br/><br/><br/>
                <h6>
                    array2 배열 출력하기<br/>
                    {
                        array2.map(
                            (item, idx) =>
                                (<figure key={idx} className="photo"><img style={{width:"150px"}} alt={item.carphoto} src={require(`../image/${item.carphoto}`)}/>
                                    <figcaption>{item.carname}<br/>{item.carprice}</figcaption></figure>)
                        )
                    }
                </h6>
            </div>
        </div>
    );
}

export default SixComponet;