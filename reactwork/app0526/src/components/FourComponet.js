import React, {useState} from 'react';
import car1 from "../image/car1.png";
import car2 from "../image/car2.png";
import car3 from "../image/car3.png";
import car4 from "../image/car4.png";

function FourComponet(props) {
    const [CangeFontSize, setCangeFontSize] = useState(20);
    const [CangeBgColor,setCangeBgColor] = useState("orange");
    const [CangeFgColor,setCangeFgColor] = useState("black");
    const [myCar, setMyCar]=useState(car1);
    const [shpwMyCar, setShowMyCar] = useState(false);
    const changeFontSize = (e) =>{
        setCangeFontSize(e.target.value);

    }
    const changeBgColor = (e) => {
        setCangeBgColor(e.target.value);
    }
    const changeFgColor = (e) =>{
        setCangeFgColor(e.target.value);

    }
    const  changeCar = (e) =>{
        setMyCar(e.target.value);
    }
    return (
        <div>
            <h3 style={{border:"3px solid gray",backgroundColor:"#add826"}}>
                FourComponet 실습
            </h3>
            <h4>
                글자 크기
                <select onClick={changeFontSize}>
                    <option value={20}>20px</option>
                    <option value={40}>40px</option>
                    <option value={60}>60px</option>
                    <option value={80}>80px</option>
                </select>
                <br/>
                배경 색
                <br/>
                <label>
                    <input type="radio" value="orange" name="color"
                    onClick={changeBgColor}/>오렌지
                </label>
                <label>
                    <input type="radio" value="red" name="color"
                           onClick={changeBgColor}/>빨강
                </label>
                <label>
                    <input type="radio" value="yellow" name="color"
                           onClick={changeBgColor}/>노랑
                </label>
                <label>
                    <input type="radio" value="blue" name="color"
                           onClick={changeBgColor}/>파랑
                </label>
                <br/>
                글자 색
                <select onClick={changeFgColor}>
                    <option value="orange">orange</option>
                    <option value="red">red</option>
                    <option value="yellow">yellow</option>
                    <option value="blue">blue</option>
                </select>
                <br/>
                이미지
                <br/>
                <label>
                    <input type="radio" value={car1} name="car"
                           onClick={changeCar}/>내 자동차1
                </label>
                <label>
                    <input type="radio" value={car2} name="car"
                           onClick={changeCar}/>내 자동차2
                </label>
                <label>
                    <input type="radio" value={car3} name="car"
                           onClick={changeCar}/>내 자동차3
                </label>
                <label>
                    <input type="radio" value={car4} name="car"
                           onClick={changeCar}/>내 자동차4
                </label>
                <br/>
            </h4>
            <br/>
            <div className="H1" style={{fontSize:CangeFontSize + "px", backgroundColor:CangeBgColor, color:CangeFgColor }}>오늘은 금요일 인데</div>

            <br/>
            <label>
                <input type="checkbox"
                       onClick={(e)=> {
                           setShowMyCar(e.target.checked);
                       }}/> 사진 보이기, 숨기기                &nbsp;
            </label>
            <br/>
            {
                shpwMyCar    &&
            <img alt="이거 이미지야" src={myCar} />
            }
        </div>
    );
}

export default FourComponet;