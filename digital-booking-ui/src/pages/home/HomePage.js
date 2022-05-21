import { makeStyles } from "@material-ui/core";
import React from "react";

const HomePage = () => {
  const classes = useStyles();
  return <main className={classes.body}>Home</main>;
};

export default HomePage;

const useStyles = makeStyles(() => ({
  body: {
    height: "85vh", //100vh - nav Heigth
    border: "2px solid black",
  },
}));
