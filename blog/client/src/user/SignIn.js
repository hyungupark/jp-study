import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

function SignIn(props) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [process, setProcess] = useState(0);
  const navigate = useNavigate();

  const usernameChange = (event) => {
    setUsername(event.target.value);
  };

  const passwordChange = (event) => {
    setPassword(event.target.value);
  };

  const processChange = (value) => {
    setProcess(value);
  };

  const singInSubmit = (event) => {
    event.preventDefault();
    const data = { username, password };
    fetch("http://localhost:8080/members/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Success : " + JSON.stringify(data));
        console.log(data.data.id);

        if (data.success) {
          navigate("/");
          props.signIn(data.data.id);
          sessionStorage.setItem("sessionId", data.data.id);
        } else {
          processChange(1);
        }
      })
      .catch((error) => {
        console.log("Fail : " + error);
        processChange(1);
      });
  };

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        flexDirection: "column",
        height: "60vh",
      }}
    >
      <h2 style={{ fontWeight: "bold", fontSize: "70px" }}>Sign IN</h2>

      {process === 0 && (
        <form
          onSubmit={singInSubmit}
          style={{
            display: "flex",
            flexDirection: "row",
            gap: "5px",
            width: "400px",
          }}
        >
          <div
            style={{
              display: "flex",
              flexDirection: "column",
              gap: "10px",
              flex: 1,
            }}
          >
            <div style={{ display: "flex", alignItems: "center", gap: "5px" }}>
              <label style={{ width: "90px" }}>UserName :</label>
              <input
                type="text"
                value={username}
                onChange={usernameChange}
                style={{
                  flex: 1,
                  padding: "5px",
                  border: "1px solid #ccc",
                  borderRadius: "5px",
                }}
              />
            </div>
            <div style={{ display: "flex", alignItems: "center", gap: "5px" }}>
              <label style={{ width: "90px" }}>PassWord :</label>
              <input
                type="text"
                value={password}
                onChange={passwordChange}
                style={{
                  flex: 1,
                  padding: "5px",
                  border: "1px solid #ccc",
                  borderRadius: "5px",
                }}
              />
            </div>
          </div>
          <button
            type="submit"
            style={{
              width: "60px",
              height: "67px",
              backgroundColor: "#a9a9a9",
              color: "#fff",
              border: "none",
              borderRadius: "5px",
              cursor: "pointer",
              fontSize: "24px",
            }}
          >
            →
          </button>
        </form>
      )}

      {process === 1 && (
        <div
          style={{
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            gap: "10px",
          }}
        >
          <p style={{ fontWeight: "bold", fontSize: "28px" }}>
            Check ID or PW!
          </p>
          <Link
            to="/signup"
            style={{
              fontSize: "20px",
              color: "#007bff",
              textDecoration: "underline",
            }}
          >
            회원가입 하러 가기
          </Link>
        </div>
      )}
    </div>
  );
}

export default SignIn;
