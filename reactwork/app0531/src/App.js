import logo from './logo.svg';
import {useState} from "react";
import OneComponet from "./components/OneComponet";
import TwoComponet from "./components/TwoComponet";
import ThreeComponet from "./components/ThreeComponet";
import FourComponet from "./components/FourComponet";
import FiveComponet from "./components/FiveComponet";
import SixComponet from "./components/SixComponet";
import SevenComponet from "./components/SevenComponet";
import EightComponet from "./components/EightComponet";
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
        <h2>2023-05-31 리액트 수업</h2>
        <select className="form-select"
                style={{width:"200px",marginLeft:"100px"}}
                onChange={ChangeComponent}>
          <option value={1}>OneComponet</option>
          <option value={2}>TwoComponet</option>
          <option value={3}>ThreeComponet</option>
          <option value={4}>FourComponet</option>
          <option value={5}>FiveComponet</option>
          <option value={6}>SixComponet</option>
          <option value={7}>SevenComponet</option>
          <option value={8}>EightComponet</option>
        </select>
        <br/><br/>

        {idx===1?<OneComponet/>:idx===2?<TwoComponet/>:idx===3?<ThreeComponet/>:idx===4?<FourComponet/>:idx===5?<FiveComponet/>:idx===6?<SixComponet/>:idx===7?<SevenComponet/>:<EightComponet/>}

      </div>
  );
}

export default App;
