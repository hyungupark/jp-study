import Nav from "./Nav";
import { Route, Routes } from "react-router-dom";
import Home from "./Home";
import BlogList from "./blog/BlogList";
import { useState } from "react";
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
    <>
      <Nav userId={userId} signIn={signIn} signOut={signOut} />
      <Routes>
        <Route path={"/"} element={<BlogList />} />
        <Route path={"/home"} element={<Home />} />
        <Route path={"/SignUp"} element={<SignUp />} />
        <Route path={"/SignIn"} element={<SignIn signIn={signIn} />} />
      </Routes>
    </>
  );
}

export default App;
