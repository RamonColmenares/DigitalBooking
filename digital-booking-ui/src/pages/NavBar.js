import React, { useState } from "react";
import {
  AppBar,
  Button,
  IconButton,
  makeStyles,
  Toolbar,
} from "@material-ui/core";
import MenuIcon from "@material-ui/icons/Menu";
import Logo from "../assets/Logo";
import { Link } from "react-router-dom";
import DrawerPanel from "./DrawerPanel";

const NavBar = () => {
  const classes = useStyles();
  const [openDrawer, setOpenDrawer] = useState(false);
  return (
    <>
      <AppBar position="static" color="default" className={classes.nav}>
        <Toolbar className={classes.contentStyle}>
          <Link to="/">
            <Logo />
          </Link>
          <div className={classes.wrapperButtons}>
            <Link to="/signup">
              <Button variant="outlined" color="primary">
                Sign Up
              </Button>
            </Link>
            <Link to="/login">
              <Button variant="outlined" color="primary">
                Log In
              </Button>
            </Link>
          </div>
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
