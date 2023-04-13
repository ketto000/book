import React, {useState} from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate } from "react-router-dom";


const FileData = () => {


    const navigate = useNavigate(); //변수 할당시켜서 사용

    const [book, setBook] = useState({
        title: "",
        author: "",
        contents: "",
        filekey: "",
    });


    const changeValue = (e) =>{
        setBook({
            ...book,
            [e.target.name]:e.target.value
        })
    }

    const [files,setFiles] = useState([]);

    function onFileUpload(event) {
        event.preventDefault();
        setFiles([
            ...files,
            event.target.files[0]

        ]);
    }



    const submitBook = (e) =>{
        e.preventDefault();//submit이 action을 안타고 자기 할일을 그만한

        const formData = new FormData();
        // formData.append('body', JSON.stringify(book));



        for (let i = 0; i < files.length; i++) {
            formData.append('files', files[i]);
        }
        formData.append('key', new Blob([ JSON.stringify(book) ], {type : "application/json"}));


        fetch("/api/book",{
            method:"POST",
            // headers:{
            //    "Content-Type": "multipart/form-data"
            // },
            body: formData

        }).then((res)=>{
            console.log(1,res);
            if(res.status === 201) {
                return res.json();
            }else{
                return null;
            }
        }).then((res)=>{
            if(res !== null){

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

            <Form.Group controlId="formFileMultiple" className="mb-3">
                <Form.Label>Multiple files input example</Form.Label>
                <Form.Control type="file" multiple  onChange={(e) => {onFileUpload(e)}} />
            </Form.Group>

            <Button variant="primary" type="submit">
                Submit
            </Button>
            { book.title}
            { book.author}

        </Form>

    );
}
export default FileData;