import Nav from "./Nav";
import {Route, Routes} from "react-router-dom";
import Home from "./Home";
import BlogList from "./blog/BlogList";
import {useState} from "react";
import Landing from "./Landing";
import BlogDetail from "./blog/BlogDetail";
import SignUp from "./user/SignUp";
import SignIn from "./user/SignIn";

function App() {
    const [userId, setUserId] = useState("");

    function signIn(userId) {
        setUserId(userId);
    }

    function signOut() {
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
            </Routes>
        </div>
    );
}

export default App;
