import React, {useEffect, useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import Spinner from 'react-bootstrap/Spinner';
import Button from 'react-bootstrap/Button';


const Detail = (props) => {



    // const id=props.match.params.id;
    const navigate = useNavigate(); //변수 할당시켜서 사용
    //라우터 v6에 의한 코드
    const {id} = useParams();

    const [book, setBook] = useState({
        id: "",
        title: "",
        author: ""
    });


    useEffect(() => {
        fetch("/api/" + id).then((res) => res.json()).then((res) => {
            setBook(res);
        });
    }, []);

    const go_update = () =>{
          navigate(`/updateForm/`+id);

    }


    const deleteBook = () => {
        fetch("/api/book/" + id, {
            method: "DELETE"
        }).then((res) => res.text()
            .then((res) => {
                if(res === 'ok'){
                    navigate(`/`);
                } else {
                    alert("삭제 실패");
                }
            }
            ))};


return (
    <div>
        <Spinner animation="border" variant="primary"/>
        <Spinner animation="border" variant="secondary"/>
        <Spinner animation="border" variant="success"/>
        <Spinner animation="border" variant="danger"/>
        <Spinner animation="border" variant="warning"/>
        <Spinner animation="border" variant="info"/>
        <Spinner animation="border" variant="light"/>
        <Spinner animation="border" variant="dark"/>
        <Spinner animation="grow" variant="primary"/>
        <Spinner animation="grow" variant="secondary"/>
        <Spinner animation="grow" variant="success"/>
        <Spinner animation="grow" variant="danger"/>
        <Spinner animation="grow" variant="warning"/>
        <Spinner animation="grow" variant="info"/>
        <Spinner animation="grow" variant="light"/>
        <Spinner animation="grow" variant="dark"/>

        <h1>책상세보기{id}</h1>
        <Button variant="warning" onClick={go_update}>수정</Button>{' '}
        <Button variant="danger" onClick={deleteBook}>삭제</Button>

        <h2>{book.author}</h2>
        <h4>{book.title}</h4>

    </div>
);
}
;

export default Detail;