import {useEffect, useState} from "react";

function BlogList() {
    const [blogs, setBlogs] = useState([]);

    useEffect(() => {
        fetchData();
    }, []);

    async function fetchData() {
        const res = await fetch("http://localhost:8080/blogs");
        const data = await res.json();
        console.log(data);
    }

    return (
        <div>
            {blogs.map((blog, index) => {
                return <div>{blog.title}</div>;
            })}
        </div>
    );
}

export default BlogList;
