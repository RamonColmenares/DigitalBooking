import React from "react";
import StarIcon from "@material-ui/icons/Star";
import { makeStyles } from "@material-ui/core";

const PunctuationDisplayerWithStars = () => {
  const classes = useStyles();
  return (
    <div className={classes.container}>
      <div className={classes.review}>
        <p>Very Good</p>
        <div className="stars">
          <StarIcon fontSize="small" />
          <StarIcon fontSize="small" />
          <StarIcon fontSize="small" />
          <StarIcon fontSize="small" />
          <StarIcon fontSize="small" />
        </div>
      </div>
      <div className={classes.punctuation}>8</div>
    </div>
  );
};

export default PunctuationDisplayerWithStars;

const useStyles = makeStyles((theme) => ({
  container: {
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    gap: "10px",
  },
  review: {
    textAlign: "right",
  },
  punctuation: {
    fontSize: "30px",
    fontWeight: "bold",
    color: theme.palette.white,
    backgroundColor: theme.palette.secondary.main,
    padding: "4px 12px",
    borderRadius: "5px",
  },
}));
