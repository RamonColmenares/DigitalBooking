import React, { useState } from "react";
import { Link, useLocation } from "react-router-dom";
import {
  AppBar,
  Button,
  IconButton,
  makeStyles,
  Toolbar,
} from "@material-ui/core";
import MenuIcon from "@material-ui/icons/Menu";
import Logo from "../assets/Logo";
import DrawerPanel from "./DrawerPanel";
import User from "../common/Displayers/User";
import { useAuthStore } from "../stores/auth";

const NavBar = () => {
  const classes = useStyles();
  const [openDrawer, setOpenDrawer] = useState(false);

  const userName = useAuthStore((s) => s.name);
  const userSurname = useAuthStore((s) => s.surname);

  return (
    <>
      <AppBar position="static" color="default" className={classes.nav}>
        <Toolbar className={classes.contentStyle}>
          <Link to="/">
            <Logo />
          </Link>
          {userName ? (
            <User name={userName} surname={userSurname} navbar />
          ) : (
            <AuthActions />
          )}
          <IconButton
            edge="start"
            className={classes.menuButton}
            color="inherit"
            aria-label="menu"
            onClick={() => setOpenDrawer(true)}
          >
            <MenuIcon />
          </IconButton>
        </Toolbar>
      </AppBar>
      <DrawerPanel open={openDrawer} setOpen={setOpenDrawer} />
    </>
  );
};

export default NavBar;

const AuthActions = () => {
  const classes = useStyles();

  const { pathname } = useLocation();

  const isNotLoginPage = pathname !== "/login";
  const isNotSignPage = pathname !== "/signup";

  return (
    <div className={classes.wrapperButtons}>
      {isNotSignPage && (
        <Link to="/signup">
          <Button variant="outlined" color="primary">
            Sign Up
          </Button>
        </Link>
      )}
      {isNotLoginPage && (
        <Link to="/login">
          <Button variant="contained" color="primary" className="login-button">
            Log In
          </Button>
        </Link>
      )}
    </div>
  );
};

const useStyles = makeStyles((theme) => ({
  nav: {
    height: "10vh",
    boxShadow: "0px 6px 18px -8px #000000",
    display: "flex",
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between",
  },
  contentStyle: {
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
    width: "100%",
  },
  wrapperButtons: {
    "& > a": {
      display: "inline-block",
      width: "200px",
      margin: "0 20px",
      "& > button": {
        width: "100%",
      },
    },
    "& .login-button": {
      color: theme.palette.white,
      fontWeight: "bold",
    },
    "@media (max-width:800px)": {
      display: "none",
    },
  },
  menuButton: {
    display: "none",
    "@media (max-width:800px)": {
      display: "block",
    },
  },
}));
