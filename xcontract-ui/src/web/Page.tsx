import Content from "./Content";
import Header from "./Header";
import Menu from "./Menu";
import SubMenu from "./SubMenu";
import UserInfo from "./UserInfo";

const Page = () => {
  return (
    <div className="container-fluid vh-100 d-flex m-0 p-0 row">
      <div className="col-1">
        <div className="row">
          <div className="user-info col-12">
            <UserInfo />
          </div>
          <div className="nav-menu col-12">
            <Menu />
          </div>
        </div>
      </div>
      <div className="col-11">
        <div className="row">
          <div className="sub-menu col-12">
            <Header />
          </div>
          <div className="sub-menu col-12">
            <SubMenu />
          </div>
          <div className="content col-12">
            <Content />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Page;
