import React, { useEffect } from "react";
import { IconButton, makeStyles } from "@material-ui/core";
import NavigateBeforeIcon from "@material-ui/icons/NavigateBefore";
import { CATEGORIES } from "../../models/business/categories";
import { useNavigate } from "react-router-dom";
import { useAccommodationStore } from "../../stores/accommodation";
import CenterContainer from "../../common/Displayers/CenterContainer";
import ErrorSplash from "../../assets/ErrorSplash";

const AccommodationPage = () => {
  const classes = useStyles();
  const navigate = useNavigate();

  const accommodation = useAccommodationStore((s) => s.data);
  const loading = useAccommodationStore((s) => s.loading);
  const loaded = useAccommodationStore((s) => s.loaded);
  const error = useAccommodationStore((s) => s.error);
  const fetchData = useAccommodationStore((s) => s.fetchData);

  useEffect(() => {
    fetchData();
  }, [fetchData]);

  const handleGoBack = () => {
    navigate(-1);
  };

  if (true) {
    return <CenterContainer>{/* <ErrorSplash /> */}</CenterContainer>;
  }

  if (loading) return <h1>Cargando</h1>;
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
