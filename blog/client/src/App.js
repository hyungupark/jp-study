import Nav from "./Nav";
import {Route, Routes} from "react-router-dom";
import Home from "./Home";
import BlogList from "./blog/BlogList";
import {use, useState} from "react";
import Landing from "./Landing";
import BlogDetail from "./blog/BlogDetail";
import SignUp from "./user/SignUp";
import SignIn from "./user/SignIn";
import CreateBlog from "./blog/CreateBlog";

function App() {
    const [userId, setUserId] = useState(window.sessionStorage.getItem("sessionId"));

    function signIn(userId) {
        setUserId(userId);
    }

    function signOut() {
        window.sessionStorage.removeItem("sessionId");
        setUserId("");
    }

    return (
        <div style={{
            width: "100%",
            height: "100%",
        }}>
            <Nav userId={userId} signIn={signIn} signOut={signOut}/>
            <Routes>
                <Route path={"/"} element={<Landing/>}/>
                <Route path={"/blogs"} element={<BlogList/>}/>
                <Route path={"/blog"} element={<BlogDetail/>}/>
                <Route path={"/blog/:blodId"} element={<BlogDetail/>}/>
                <Route path={"/home"} element={<Home/>}/>
                <Route path={"/SignUp"} element={<SignUp/>}/>
                <Route path={"/SignIn"} element={<SignIn signIn={signIn}/>}/>
                <Route path={"/create"} element={<CreateBlog userId={userId}/>}/>
            </Routes>
        </div>
    );
}

export default App;
