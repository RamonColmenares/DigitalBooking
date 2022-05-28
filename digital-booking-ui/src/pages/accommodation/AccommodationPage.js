import React from "react";
import { IconButton, makeStyles } from "@material-ui/core";
import NavigateBeforeIcon from "@material-ui/icons/NavigateBefore";
import { CATEGORIES } from "../../models/business/categories";
import { useNavigate } from "react-router-dom";

const accommodation = {
  crimg:
    "https://images.unsplash.com/photo-1618773928121-c32242e63f39?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170",
  category: "Hotels",
  title: "Freehand Toronto - Premium King Room",
  location: "Toronto, Canada",
  description:
    "Designed by famed duo Roman & Williams, with custom art by Bard College students and alumni throughout.",
};

const AccommodationPage = () => {
  const classes = useStyles();
  const navigate = useNavigate();

  const handleGoBack = () => {
    navigate(-1);
  };

  return (
    <main className={classes.body}>
      <section className={classes.header}>
        <IconButton onClick={handleGoBack}>
          <NavigateBeforeIcon fontSize="large" className="back-arrow" />
        </IconButton>
        <div className={classes.title}>
          <p>{CATEGORIES[accommodation.category]}</p>
          <h3>{accommodation.title}</h3>
        </div>
      </section>
    </main>
  );
};

export default AccommodationPage;

const useStyles = makeStyles((theme) => ({
  body: {
    minHeight: "85vh",
  },
  header: {
    backgroundColor: theme.palette.secondary.main,
    color: theme.palette.white,
    padding: "10px 40px",
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
    "& .back-arrow": {
      color: theme.palette.white,
    },
    "@media (max-width:500px)": {
      padding: "10px",
    },
  },
  title: {
    textAlign: "right",
    "& > p": {
      textTransform: "uppercase",
    },
    "& > h3": {
      fontWeight: "bold",
      fontSize: "24px",
      "@media (max-width:500px)": {
        fontSize: "18px",
      },
    },
  },
}));
