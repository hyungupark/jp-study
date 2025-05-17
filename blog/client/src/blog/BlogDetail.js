import {useSearchParams} from "react-router-dom";
import {useEffect, useState} from "react";

function BlogDetail(props) {
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
        fetchData(blogId);
    }, [blogId]);

    async function fetchData(blogId_) {
        const res = await fetch(`http://localhost:8080/blogs/${blogId_}`);
        const json = await res.json();
        setBlog(json.data)
        console.log(json.data);
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
            </div>
        </div>
    );
}

export default BlogDetail;