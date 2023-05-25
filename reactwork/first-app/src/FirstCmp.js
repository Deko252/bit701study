import React,{Component} from "react";
import img1 from "./image/1.jpg"
import img2 from "./image/11.jpg"
//class 로 컴포넌트 생성하기
class FirstCmp extends Component{

    render(){//클래스 일때만
        return(
            <div>
                <h2 style={{color:"green",border:"2px solid orange",background:"pink"}}>
                    React 첫 컴포넌트
                </h2>
                <h4>src 의 이미지 나타내기</h4>
                <img alt="이미지1"src={img1}style={{width:"200px"}} />
                <img alt="이미지2"src={img2}style={{width:"100px"}} />
                {/* public의 이미지는 상대주소로*/}
                <h4>public 의 이미지 나타내기</h4>
                <img alt="이미지3" style={{width:"100px"}} src={"./5.jpg"}/>
            </div>
        )
    }
}
//default로 export 할 경우 import 시에 이름을 마음대로 정할 수 있다.
//export default 는 파일내에서 한번만 가능하다.
//export default FirstCmp;
export  {FirstCmp};