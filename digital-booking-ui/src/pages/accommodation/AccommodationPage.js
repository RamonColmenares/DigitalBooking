import React, { useEffect } from "react";
import { makeStyles } from "@material-ui/core";
import { useNavigate } from "react-router-dom";
import { useAccommodationStore } from "../../stores/accommodation";
import CenterContainer from "../../common/Displayers/CenterContainer";
import ErrorSplash from "../../assets/ErrorSplash";
import HeaderAccommodation from "../../components/accomodation/HeaderAccommodation";
import LocationSection from "../../components/accomodation/LocationSection";

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

  if (error) {
    return <CenterContainer>{/* <ErrorSplash /> */}</CenterContainer>;
  }

  return (
    <>
      {loading && !loaded ? (
        <h1>Loading..</h1>
      ) : (
        <>
          <HeaderAccommodation accommodation={accommodation} />
          <LocationSection accommodation={accommodation} />
        </>
      )}
    </>
  );
};

export default AccommodationPage;

const useStyles = makeStyles((theme) => ({
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
