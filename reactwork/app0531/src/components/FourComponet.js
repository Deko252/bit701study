import React, {useEffect, useRef, useState} from 'react';
import {Editor} from "@toast-ui/react-editor";
import '@toast-ui/editor/dist/toastui-editor.css';


function FourComponet(props) {
    const [content , setContent] = useState("");
    const toastRef = useRef();
    useEffect(()=>{
        toastRef.current?.getInstance().setHTML("");
    },[]);
    const buttonEvent=()=>{
        let s = toastRef.current?.getInstance().getHTML();
        setContent(s);
        alert(s.length);
    }
    return (
        <div>
            <h2 className="alert alert-info">네번째입니다.</h2>
            <h3> Editor Toast</h3>
            <Editor
                ref={toastRef}
                placeholder="내용을 입력해주세요."
                previewStyle="vertical" // 미리보기 스타일 지정
                height="300px" // 에디터 창 높이
                initialEditType="wysiwyg" // 초기 입력모드 설정(디폴트 markdown)
                toolbarItems={[
                    // 툴바 옵션 설정
                    ['heading', 'bold', 'italic', 'strike'],
                    ['hr', 'quote'],
                    ['ul', 'ol', 'task', 'indent', 'outdent'],
                    ['table', 'image', 'link'],
                    ['code', 'codeblock']
                ]}
            ></Editor>
            <br/>
            <button type="button" onClick={buttonEvent}>Editor 읽기</button>
            <hr/>
            {content}
        </div>
    );
}

export default FourComponet;