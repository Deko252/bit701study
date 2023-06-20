import React from 'react';
import PostingData from "../data/PostingData.json";

function TwoComponent(props) {
    const posting = PostingData.deal;
    return (
        <div>
            <h2 className="alert alert-info">TwoComponent - PostingData 출력</h2>
            {
                posting.map((post,idx) =>
                    <div style={{textAlign:"center", float:"left", marginLeft:"40px", width:"400px"}}>
                        <img alt="" src={post.img}/>
                        <div style={{width:"100%"}}>
                            회사명 : {post.company}
                        </div>
                        <div style={{width:"100%"}}>
                            제품 : {post.title}
                        </div>
                        <div style={{width:"100%"}}>
                            가격 : {post.price}
                        </div>
                        <div style={{width:"100%"}}>
                            할인 : {post.sale}
                        </div>
                    </div>
                )
            }
        </div>
    );
}

export default TwoComponent;