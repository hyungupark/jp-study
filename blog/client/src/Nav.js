import logo from './logo.svg';
import {Link} from "react-router-dom";

function Nav(props) {
    return (
        <div>
            <div style={{
                display: "flex",
                alignItems: "center",
                justifyContent: "space-between",
                padding: "10px",
                borderBottom: "1px solid lightgray",
            }}>
                <div style={{
                    width: "100%",
                    display: "flex",
                    alignItems: "center",
                }}>
                    <div style={{
                        width: "200px",
                    }}>
                        <Link to={"/"}>
                            <img src={logo} alt="logo" style={{
                                height: "50px",
                            }}/>
                        </Link>
                    </div>
                    <div style={{
                        width: "100%",
                        display: "flex",
                        gap: "30px",
                    }}>
                        <Link to={"/blogs"} className={"custom-link"}>Blogs</Link>
                        {props.userId &&
                            <Link to={`/profile/${props.userId}`} className={"custom-link"}>My page</Link>}
                    </div>
                </div>
                <div style={{
                    width: "100px",
                    cursor: "pointer",
                }}>
                    {props.userId ?
                        <div onClick={props.signOut}>
                            Sign out
                        </div>
                        :
                        <Link to={"/signin"} className={"custom-link"}>
                            Sign in
                        </Link>
                    }
                </div>
            </div>
        </div>
    );
}

export default Nav;
