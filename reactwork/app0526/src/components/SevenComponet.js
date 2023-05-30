import React, {useState} from 'react';

function SevenComponet(props) {
    const [array,setArray]=useState(["red","green","blue","orange","gray","pink","white","yellow"]);
    return (
        <div>
            <h3 style={{border:"3px solid gray",backgroundColor:"#add826"}}>
                SevenComponet 실습
            </h3>
            <div>
                <h5>색상을 추가해 보세요.(색상에서 더블클릭시 삭제)</h5>
                <input type="text" defaultValue={"#ccffcc"} onKeyUp={(e) =>
                {
                  //alert(e.target.value);
                  //setArray(array.push(e.target.value)); //배열에 추가안됨

                if(e.key === "Enter"){
                      //리액트는 배열에 추가를 concat을 이용해야한다
                      setArray(array.concat(e.target.value));
                      e.target.value="";
                }
                }}/>
                <br/>
                <input type="color"
                    onBlur={(e)=>{
                        setArray(array.concat(e.target.value));
                    }
                }
                />
            </div>
            <div>
                array 배열 출력하기<br/>
                {
                    array.map(
                        (color,idx) =>
                            (
                                <div style={{clear:"both",marginLeft:"100px",width:"200px",marginBottom:"35px"}}>
                                    <div key={idx} style={{backgroundColor:color}} className="circle"
                                    onDoubleClick={()=> {
                                        //idx 번지를 제거
                                        alert((idx + 1) + "번째 색상 제거완료.");
                                        setArray([
                                            ...array.slice(0,idx),
                                            ...array.slice(idx+1,array.length)
                                        ]);
                                    }
                                    }
                                    >{idx + 1}</div>
                                    <span>{color}</span>
                                </div>
                            )
                    )
                }
            </div>
        </div>
    );
}

export default SevenComponet;