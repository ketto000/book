import React from 'react';
import {Link} from "react-router-dom";
import Card from 'react-bootstrap/Card';
import Button from "react-bootstrap/Button";

const Bookitem = (props) => {

    const {id,title,author} = props.book;

    return (
        <Card style={{ width: '18rem' }} className="icards">
            <Card.Body>
                <Card.Title>{id}: {title}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">{author}</Card.Subtitle>
                <Button variant="outline-info">
                    <Link  to={'/book/'+id} className="btn btn-btn-parimary">상세보기</Link>
                </Button>
            </Card.Body>
        </Card>
    );
};

export default Bookitem;