import logo from './logo.svg';
import './App.css';
import {FirstCmp} from "./FirstCmp";
import SecondCmp from "./SecondCmp";
import ThirdCmp from "./ThirdCmp"
import Fourth from "./Fourth";
import FifthCmp from "./FifthCmp";
import {useState} from "react";
function App() {
    const [idx,setidx] = useState(1);
  return (
    <div className="App">
        {/*<ThirdCmp/>
        <SecondCmp/>
        <FirstCmp/>
        <Fourth/>
        <FifthCmp/>*/}
        <select onChange={(e) => {
            setidx(Number(e.target.value));
        }}>
            <option value={1} selected>1번</option>
            <option value={2}>2번</option>
            <option value={3}>3번</option>
            <option value={4}>4번</option>
            <option value={5}>5번</option>
        </select>
        {
            idx == 1?<FirstCmp/>:idx == 2?<SecondCmp/>:idx == 3?<ThirdCmp/>:idx  == 4?<Fourth/>:<FifthCmp/>
        }
    </div>
  );
}

export default App;
