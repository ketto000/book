import './App.css';
import Container from "react-bootstrap/Container";
import Home from "./page/book/Home";
import {Routes,Route} from "react-router-dom";
import Header from "./component/Header";

import Detail from "./page/book/Detail";
import LoginForm from "./page/user/LoginForm";
import JoinForm from "./page/user/JoinForm";
import UpdateForm from "./page/book/UpdateForm";
import FileData from "./page/book/FileData";
import SaveForm_ex from "./page/book/SaveForm_ex";
// import SaveForm from "./page/book/SaveForm";
// import SaveForm_ex from "./page/book/SaveForm_ex";
//

function App() {





  return (
    <div>
      <Header />

      <Container>
          <Routes>
          <Route path="/"  element={<Home />} />
          <Route path="/saveForm"  element={<FileData />} />
          <Route path="/book/:id"  element={<Detail />} />
          <Route path="/loginForm"  element={<SaveForm_ex />} />
          <Route path="/joinForm"  element={<JoinForm />} />
          <Route path="/updateForm/:id"  element={<UpdateForm />} />
          </Routes>
        </Container>




    </div>
  );
}

export default App;
