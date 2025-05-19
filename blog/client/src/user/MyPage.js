import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

function MyPage() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [sessionId, setSessionId] = useState("");

  const navigate = useNavigate();

  const usernameChange = (event) => {
    setUsername(event.target.value);
  };

  const passwordChange = (event) => {
    setPassword(event.target.value);
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/members/findById", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({
            id: sessionStorage.getItem("sessionId"),
          }),
        });

        if (!response.ok) {
          throw new Error("네트워크 응답이 좋지 않습니다.");
        }

        const result = await response.json();

        if (result) {
          setUsername(result.data.username);
          setPassword(result.data.password);
          setSessionId(sessionStorage.getItem("sessionId"))
          console.log(result);
        }
      } catch (error) {
        console.error(error);
      }
    };
    fetchData();
  }, []);


const modifySubmit = (event) => {
  event.preventDefault();

  const data = {
    id: sessionId,
    username,
    password,
  };

  fetch("http://localhost:8080/members/updateMember", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Modify Success:", data);
      if (data.success) {
        sessionStorage.removeItem("sessionId");
        alert("정상적으로 수정되었습니다!\n다시 로그인 부탁드립니다!");
        navigate("/");
      }
    })
    .catch((error) => {
      console.error("Modify Error:", error);
    });
};


const deleteSubmit = (event) => {
  event.preventDefault();

  fetch("http://localhost:8080/members/deleteMember", {
    method: "DELETE",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ id: sessionId }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Delete Success:", data);
      if (data.success) {
        sessionStorage.removeItem("sessionId");
        alert("정상적으로 탈퇴 되었습니다!");
        navigate("/");
      }
    })
    .catch((error) => {
      console.error("Delete Error:", error);
    });
};

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        flexDirection: "column",
        height: "52vh",
      }}
    >
      <h2 style={{ fontWeight: "bold", fontSize: "70px" }}>My Page</h2>

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
      <div
        style={{
          display: "flex",
          flexDirection: "row",  // 버튼들을 가로로 배치
          gap: "10px",           // 버튼 간 간격 설정
        }}
      >
        <button
        
          onClick={modifySubmit}
          style={{
            width: "80px",  // 버튼 크기
            height: "50px",
            backgroundColor: "#a9a9a9",
            color: "#fff",
            border: "none",
            borderRadius: "5px",
            cursor: "pointer",
            fontSize: "14px", // 폰트 크기
          }}
        >
          MODIFY
        </button>
        <button
          onClick={deleteSubmit}
          style={{
            width: "80px",  // 버튼 크기
            height: "50px",
            backgroundColor: "#a9a9a9",
            color: "#fff",
            border: "none",
            borderRadius: "5px",
            cursor: "pointer",
            fontSize: "14px", // 폰트 크기
          }}
        >
          DELETE
        </button>
      </div>
    </div>
  );
}

export default MyPage;
