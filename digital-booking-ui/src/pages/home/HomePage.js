import { makeStyles } from "@material-ui/core";
import React from "react";
import Categories from "../../components/home/Categories";

const HomePage = () => {
  const classes = useStyles();
  return (
    <main className={classes.body}>
      <Categories />
    </main>
  );
};

export default HomePage;

const useStyles = makeStyles(() => ({
  body: {
    minHeight: "85vh", //100vh - nav Heigth
    border: "2px solid black",
    padding: "0 40px",
  },
}));
