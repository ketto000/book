import React, {useEffect, useState} from 'react';
import Bookitem from "../../component/Bookitem";

const Home = () => {
    const [ books, setBooks] = useState([]);

    //함수 실행시 최초 한번 실행되는 것
    useEffect(()=>{
        fetch("/api").then(res=>res.json()).then(res=>{

            console.log(1,res);
            setBooks(res);

        });//비동기함수
    },[]);


    return (
        <div>
            
            {books.map((book)=>(<Bookitem key={book.id} book={book} />))}


        </div>
    );
};

export default Home;