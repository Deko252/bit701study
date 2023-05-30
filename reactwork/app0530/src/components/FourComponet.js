import React, {useRef, useState} from 'react';


function FourComponet(props) {
    const [content, setContent] = useState("");
    const [content2, setContent2] = useState("");
    const contentRef = useRef("");//변수 선언
    console.log("랜더링 중...");
    

    return (
        <div>
            <h2 className="alert alert-info">FourComponet</h2>
            <textarea style={{width:"300px", height:"100px"}}
            onChange={(e) =>{
                setContent(e.target.value);
            }}></textarea>
            <h4 className='alert alert-danger'>{content}</h4>
            <hr/>
            <textarea style={{width:"300px",height:"100px"}} ref={contentRef}></textarea>
            <button type="button" onClick={() => {
                //입력을 하다가 버튼을 누르면 그때 content2에 값이 들어가면서 랜더링이 발생한다
                setContent2(contentRef.current.value);
            }}>ref content 적용</button>
            <h4 className="alert alert-danger">{content2}</h4>
        </div>
    );
}

export default FourComponet;