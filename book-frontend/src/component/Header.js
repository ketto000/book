import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import {Link} from "react-router-dom";
import { useNavigate } from "react-router-dom";
const Header = () => {

    const navigate = useNavigate(); //변수 할당시켜서 사용
    const onClickBtn = () => {
        navigate(-1); // 바로 이전 페이지로 이동, '/main' 등 직접 지정도 당연히 가능
    };



    return (
        <>
            <Navbar bg="dark" variant="dark">
                <Container>

                    <Link to="/" className="navbar-brand">홈</Link>
                    <Nav className="me-auto">
                        <Link to="/saveForm" className="nav-link">글쓰기</Link>
                        <Link to="/joinForm" className="nav-link">회원가입</Link>
                        <Link to="/loginForm" className="nav-link">로그인</Link>
                    </Nav>
                    <button onClick={onClickBtn}></button>
                </Container>
            </Navbar>
        </>
    );
};

export default Header;