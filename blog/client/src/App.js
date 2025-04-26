import Nav from "./Nav";
import {Route, Routes} from "react-router-dom";
import Home from "./Home";
import BlogList from "./blog/BlogList";
import {useState} from "react";

function App() {
    const [userId, setUserId] = useState("");

    function signIn(userId) {
        setUserId(userId);
    }

    function signOut() {
        setUserId("");
    }

    return (
        <>
            <Nav userId={userId} signIn={signIn} signOut={signOut}/>
            <Routes>
                <Route path={"/"} element={<BlogList/>}/>
                <Route path={"/home"} element={<Home/>}/>
            </Routes>
        </>
    );
}

export default App;
