import React, {useRef, useState} from 'react';

function FiveComponet(props) {
    const [user, setUser] = useState("");
    const [java, setJava] = useState(0);
    const [mySql, setMySql] = useState(0);
    const [spring, setSpring] = useState(0);
    const [sum, setSum] = useState(0);
    const [avg, setAvg] = useState(0);
    console.log("랜더링 중...");
    const userRef = useRef("");
    const javaRef = useRef(0);
    const mySqlRef = useRef(0);
    const springRef = useRef(0);
    const sumRef = useRef(parseInt(sum));
    const avgRef = useRef(parseInt(sum/3));

    const change = () =>{
        setUser(userRef.current.value);
        setJava(parseInt(javaRef.current.value));
        setMySql(parseInt(mySqlRef.current.value));
        setSpring(parseInt(springRef.current.value));
        setSum(parseInt(sumRef));//값은 변경되지만 랜더링 되지않는다.
        setAvg(parseInt(sum/3))
    }
    return (
        <div>
            <h2 className="alert alert-info">FiveComponet</h2>

            <div>
                이름 : <input type="text" ref={userRef}/>
                <br/>
                JAVA : <input type="text" ref={javaRef}/>
                <br/>
                MySql : <input type="text" ref={mySqlRef}/>
                <br/>
                Spring : <input type="text" ref={springRef}/>
                <br/>
                <button type="button" className="btn btn-outline-danger" onClick={change}>결과 화인</button>
                <div>
                    이름 : {user} <br/>
                    JAVA : {java} <br/>
                    MySql : {mySql} <br/>
                    Spring : {spring} <br/>
                    총점 : {sum} <br/>
                    평균 : {avg}
                </div>
            </div>
        </div>
    );
}

export default FiveComponet;