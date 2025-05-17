import {useState} from "react";
import {useNavigate} from "react-router-dom";

function CreateBlog(props) {
    const navigate = useNavigate();
    const [title, setTitle] = useState("");
    const [content, setContent] = useState("");


    async function create() {
        const res = await fetch(`http://localhost:8080/blogs/${props.userId}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: title,
                content: content,
            })
        });
        navigate("/blogs", {replace: true});
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
                    <button onClick={create}>create</button>
                </div>
            </div>
        </div>
    );
}

export default CreateBlog;