import { makeStyles } from "@material-ui/core";
import React from "react";
import Categories from "../../components/home/Categories";
import SearchSection from "../../components/home/SearchSection";

const HomePage = () => {
  const classes = useStyles();
  return (
    <main className={classes.body}>
      <SearchSection />
      <Categories />
    </main>
  );
};

export default HomePage;

const useStyles = makeStyles(() => ({
  body: {
    minHeight: "85vh", //100vh - nav - footer
  },
}));
