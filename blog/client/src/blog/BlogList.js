import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";

function BlogList() {
    const [blogs, setBlogs] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        fetchData();
    }, []);

    async function fetchData() {
        const res = await fetch("http://localhost:8080/blogs");
        const data = await res.json();
        setBlogs(data.data);
    }

    return (
        <div style={{
            paddingTop: "50px",
            display: "flex",
            justifyContent: "center",
        }}>
            <div style={{
                width: "50%",
                display: "flex",
                flexDirection: "column",
            }}>
                {blogs.map((blog, index) => {
                    return (
                        <div
                            key={`${blog.title}_${index}`}
                            style={{
                                padding: "30px 0",
                                cursor: "pointer",
                                borderTop: `${index > 0 ? "1px solid lightgray" : "none"}`,
                            }}
                            onClick={() => {
                                navigate(`/blog?blog_id=${blog.id}`);
                            }}
                        >
                            <div style={{
                                display: "flex",
                                width: "200px",
                                justifyContent: "space-between",
                            }}>
                                <div>{blog.title}</div>
                                <div>{blog.author.username}</div>
                            </div>
                            <div style={{
                                paddingTop: "20px",
                                overflow: "hidden",
                                whiteSpace: "nowrap",
                                textOverflow: "ellipsis",
                            }}>
                                {blog.content}
                            </div>
                        </div>);
                })}
            </div>
        </div>
    );
}

export default BlogList;
