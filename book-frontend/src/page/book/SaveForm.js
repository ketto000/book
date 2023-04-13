import React, {useState} from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate } from "react-router-dom";

const SaveForm = (porps) => {

    const navigate = useNavigate(); //변수 할당시켜서 사용

    const [book, setBook] = useState({
        title:"",
        author:"",
        contents:"",
        filekey:"",
    });

    const changeValue = (e) =>{
        setBook({
            ...book,
          [e.target.name]:e.target.value
        })
    }

    const submitBook = (e) =>{
        e.preventDefault();//submit이 action을 안타고 자기 할일을 그만한
        fetch("/api/book",{
            method:"POST",
            headers:{
                "Content-Type":"application/json;charset=utf-8"
            },
            body:JSON.stringify(book)
        }).then((res)=>{
            console.log(1,res);
            if(res.status === 201) {
                return res.json();
            }else{
                return null;
            }
        }).then((res)=>{
            if(res !== null){
                //porps.history.push('/');//
                navigate(`/`);

            }else{
                alert("책 등록에 실패하였습니다.");
            }
        }).catch((error)=>{
            console.log(error);
            alert("책 등록에 실패하였습니다.");

        });
    };

    return (

        <Form onSubmit={submitBook}>
            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control type="text" placeholder="title"  onChange={changeValue} name="title" />

            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Author</Form.Label>
                <Form.Control type="text" placeholder="Author" onChange={changeValue} name="author" />
            </Form.Group>

             {/*<Form.Group controlId="formFile" className="mb-3">*/}
                {/*<Form.Label>Default file input example</Form.Label>*/}
                {/*<Form.Control type="file"  name="imgfile" />*/}
            {/*</Form.Group>*/}

                <Button variant="primary" type="submit">
                Submit
              </Button>
        </Form>




    );
};

export default SaveForm;