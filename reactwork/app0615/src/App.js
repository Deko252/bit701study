import logo from './logo.svg';
import {useState} from "react";
import './App.css';
import OneComponent from "./Component/OneComponent";
import TwoComponent from "./Component/TwoComponent";
import ThreeComponent from "./Component/ThreeComponent";
import FourComponent from "./Component/FourComponent";
import FiveComponent from "./Component/FiveComponent";
import SixComponent from "./Component/SixComponent";

function App() {
  const [idx, setIdx] = useState(1);

  //select 이벤트
  const ChangeComponent=(e)=>{
    //alert(e.target.value + typeof(e.target.value));

    //setter 함수가 호출 될때마다 자동 랜더링
    setIdx(Number(e.target.value));
  }
  return (
      <div className="App">
        <h2>2023-06-15 리액트 수업</h2>
        <select className="form-select"
                style={{width:"200px",marginLeft:"100px"}}
                onChange={ChangeComponent}>
          <option value={1}>OneComponent</option>
          <option value={2}>TwoComponent</option>
          <option value={3}>ThreeComponent</option>
          <option value={4}>FourComponent</option>
          <option value={5}>FiveComponent</option>
          <option value={6}>SixComponent</option>
        </select>
        <br/><br/>

        {idx===1?<OneComponent/>:idx===2?<TwoComponent/>:idx===3?<ThreeComponent/>:idx===4?<FourComponent/>:idx===5?<FiveComponent/>:<SixComponent/>}

      </div>
  );
}

export default App;
