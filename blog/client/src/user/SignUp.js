import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

function SignUp() {
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

  const singUpSubmit = (event) => {
    event.preventDefault();
    processChange(1);
    const data = { username, password };
    fetch("http://localhost:8080/members", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Success : " + data);
        processChange(2);

        setTimeout(() => {
          navigate("/SignIn");
        }, 3000);
      })
      .catch((error) => {
        console.log("Fail : " + error);
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
      <h2 style={{ fontWeight: "bold", fontSize: "70px" }}>Sign UP</h2>

      {process === 0 && (
        <form
          onSubmit={singUpSubmit}
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
                placeholder="EX> Blog"
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
                type="password"
                placeholder="EX> 1234"
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
        <p style={{ fontWeight: "bold", fontSize: "28px" }}>ING...</p>
      )}

      {process === 2 && (
        <p style={{ fontWeight: "bold", fontSize: "28px" }}>Success!!</p>
      )}
    </div>
  );
}

export default SignUp;
