import {Link, replace, useNavigate, useSearchParams} from "react-router-dom";
import {useEffect, useState} from "react";

function BlogDetail(props) {
    const navigate = useNavigate();
    const [searchParams, setSearchParams] = useSearchParams();
    const blogId = searchParams.get("blog_id")
    const [blog, setBlog] = useState({
        id: "",
        title: "",
        content: "",
        authorId: "",
        authorName: "",
    });

    useEffect(() => {
        if (blogId) {
            fetchData();
        }
    }, [blogId]);

    async function fetchData() {
        const res = await fetch(`http://localhost:8080/blogs/${blogId}`);
        const body = await res.json();
        setBlog(body.data)
    }

    async function deleteBlog() {
        if (window.confirm("블로그 삭제하시겠습니까?")) {
            const res = await fetch(`http://localhost:8080/blogs/${blogId}`,
                {
                    method: "DELETE",
                    credentials: "omit",
                }
            );
            const body = await res.json();
            if (body.success) {
                navigate("/blogs", {replace: true});
            }
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
                <h1 style={{
                    textAlign: "center",
                }}>
                    {blog.title}
                </h1>
                <div style={{
                    width: "100%",
                    textAlign: "right",
                }}>
                    by {blog.authorName}
                </div>
                <div style={{
                    paddingTop: "50px",
                }}>
                    {blog.content}
                </div>
                {
                    props.userId === blog.authorId &&
                    <div style={{
                        paddingTop: "50px",
                        display: "flex",
                        justifyContent: "center",
                        gap: "30px",
                    }}>
                        <button>
                            <Link
                                to={`/update/${blog.id}`}
                                style={{
                                    textDecoration: "none",
                                    color: "black",
                                }}
                            >
                                수정
                            </Link>
                        </button>
                        <button onClick={deleteBlog}>삭제</button>
                    </div>
                }
            </div>
        </div>
    );
}

export default BlogDetail;