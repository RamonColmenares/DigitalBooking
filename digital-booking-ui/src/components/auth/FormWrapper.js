import { makeStyles } from "@material-ui/core";
import React from "react";

const FormWrapper = ({ children }) => {
  const classes = useStyles();
  return <div className={classes.formWrapper}>{children}</div>;
};

const useStyles = makeStyles(() => ({
  formWrapper: {
    display: "flex",
    alignItems: "center",
    height: "100vh",
  },
}));

export default FormWrapper;
