import React, {useRef, useState} from 'react';

function FiveComponet(props) {
    const [user, setUser] = useState("");
    const [java, setJava] = useState(0);
    const [mySql, setMySql] = useState(0);
    const [spring, setSpring] = useState(0);
    const [sum, setSum] = useState(java + mySql + spring);
    const [avg, setAvg] = useState(sum/3);
    console.log("랜더링 중...");
    const userRef = useRef("");
    const javaRef = useRef(0);
    const mySqlRef = useRef(0);
    const springRef = useRef(0);

    const change = () =>{
        setUser(userRef.current.value);
        setJava(parseInt(javaRef.current.value));
        setMySql(parseInt(mySqlRef.current.value));
        setSpring(parseInt(springRef.current.value));

        let sum= parseInt(javaRef.current.value)+parseInt(mySqlRef.current.value)+parseInt(springRef.current.value);
        let avg= sum/3;

        setSum(parseInt(sum));//값은 변경되지만 랜더링 되지않는다.
        setAvg(avg.toFixed(1));
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

//선생님꺼
/*function FiveComponet(props) {
    const [msg,setMsg]=useState('');

    const nameRef=useRef('');
    const javaRef=useRef(0);
    const sqlRef=useRef(0);
    const springRef=useRef(0);

    //버튼 이벤트
    const buttonEvent=()=>{
        let name=nameRef.current.value;
        let java=Number(javaRef.current.value);
        let mysql=Number(sqlRef.current.value);
        let spring=Number(springRef.current.value);

        let total=java+mysql+spring;
        let avg=total/3;

        let s=`
        [시험 결과 확인]

        이 름 : ${name}
        Java  : ${java}점
        Mysql : ${mysql}점
        Spring: ${spring}점

        총 점 : ${total}점
        평 균 : ${avg.toFixed(1)}점
        `;

        setMsg(s);

        //초기화
        nameRef.current.value='';
        javaRef.current.value='';
        sqlRef.current.value='';
        springRef.current.value='';
        nameRef.current.focus();
    }

    return (
        <div>
            <h2 className='alert alert-warning'>Five Component-useRef문제</h2>
            <div style={{width:'500px'}}>
                <div style={{float:'left',width:'250px'}}>
                    이름 : <input type='text' ref={nameRef}/><br/><br/>
                    Java : <input type='text' ref={javaRef}/><br/><br/>
                    Mysql : <input type='text' ref={sqlRef}/><br/><br/>
                    Spring : <input type='text' ref={springRef}/><br/><br/>
                    <button type='button' onClick={buttonEvent}>결과확인</button>
                </div>
                <div style={{float:'right',fontFamily:'Jua',whiteSpace:'pre-line'}}>
                    {msg}
                </div>
            </div>
        </div>
    );
}*/

export default FiveComponet;