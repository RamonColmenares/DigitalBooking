import React from "react";
import { makeStyles } from "@material-ui/core";
import Categories from "../../components/home/Categories";
import SearchSection from "../../components/home/SearchSection";
import Products from "../../components/home/Products";

const HomePage = () => {
  const classes = useStyles();
  return (
    <main className={classes.body}>
      <SearchSection />
      <Categories />
      <Products />
    </main>
  );
};

export default HomePage;

const useStyles = makeStyles(() => ({
  body: {
    minHeight: "85vh", //100vh - nav - footer
  },
}));
