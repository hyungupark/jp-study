import logo from './logo.svg';
import {Link} from "react-router-dom";

function Nav(props) {
    return (
        <div style={{
            padding: "10px",
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between"
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
                    {props.userId && <Link to={"/blogs"} className={"custom-link"}>My page</Link>}
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
    );
}

export default Nav;
