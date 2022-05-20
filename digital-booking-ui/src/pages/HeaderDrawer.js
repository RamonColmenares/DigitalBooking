import React from "react";
import { IconButton, makeStyles } from "@material-ui/core";
import CloseIcon from "@material-ui/icons/Close";

const HeaderDrawer = ({ setOpen }) => {
  const classes = useStyles();
  return (
    <div className={classes.header}>
      <IconButton
        className={classes.closeButton}
        onClick={() => setOpen(false)}
      >
        <CloseIcon />
      </IconButton>
      <h2 className={classes.title}>MENU</h2>
    </div>
  );
};

export default HeaderDrawer;

const useStyles = makeStyles((theme) => ({
  header: {
    height: "20%",
    backgroundColor: theme.palette.primary.main,
  },
  closeButton: {
    color: theme.palette.white,
  },
  title: {
    color: theme.palette.white,
    position: "absolute",
    right: 10,
    top: 135,
  },
}));
