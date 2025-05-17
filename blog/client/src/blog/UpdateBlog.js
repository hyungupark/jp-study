import {useEffect, useState} from "react";
import {useNavigate, useParams, useSearchParams} from "react-router-dom";

function UpdateBlog(props) {
    const navigate = useNavigate();
    const params = useParams();
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");

    useEffect(() => {
        fetchData();
    }, []);

    async function fetchData() {
        const res = await fetch(`http://localhost:8080/blogs/${params['blogId']}`, {});
        const body = await res.json();
        setTitle(body.data.title);
        setContent(body.data.content);
    }

    async function update(props) {
        const res = await fetch(`http://localhost:8080/blogs/${params['blogId']}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: title,
                content: content,
            })
        });
        const body = await res.json();
        if (body.success) {
            navigate(-1);
        } else {
            alert("Failed to update blog!");
        }
    }

    return (
        <div style={{
            width: "100%",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
        }}>
            <div style={{
                width: "50%",
                padding: "20px"
            }}>
                <div style={{
                    width: "100%",
                    display: "flex",
                    gap: "30px",
                }}>
                    <div>Title</div>
                    <div style={{flex: 1}}>
                        <input
                            style={{width: "100%"}}
                            type={"text"}
                            value={title}
                            onChange={(event) => setTitle(event.target.value)}
                        />
                    </div>
                </div>
                <div style={{
                    width: "100%",
                    paddingTop: "30px",
                }}>
                    <div>Content</div>
                    <textarea
                        style={{
                            width: "100%",
                            height: "300px",
                        }}
                        value={content}
                        onChange={(event) => setContent(event.target.value)}
                    />
                </div>
                <div style={{textAlign: "center", paddingTop: "30px"}}>
                    <button onClick={update}>수정</button>
                </div>
            </div>
        </div>
    );
}

export default UpdateBlog;