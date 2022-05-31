import React, { useEffect } from "react";
import { makeStyles } from "@material-ui/core";
import { useNavigate } from "react-router-dom";
import { useAccommodationStore } from "../../stores/accommodation";
import CenterContainer from "../../common/Displayers/CenterContainer";
import ErrorSplash from "../../assets/ErrorSplash";
import HeaderAccommodation from "../../components/accomodation/HeaderAccommodation";
import LocationSection from "../../components/accomodation/LocationSection";
import LikeAndShareSection from "../../components/accomodation/LikeAndShareSection";
import Gallery from "../../components/accomodation/Gallery";
import DescriptionSection from "../../components/accomodation/DescriptionSection";
import ServicesSection from "../../components/accomodation/ServicesSection";

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
          <LikeAndShareSection />
          <Gallery />
          <DescriptionSection accommodation={accommodation} />
          <ServicesSection accommodation={accommodation} />
        </>
      )}
    </>
  );
};

export default AccommodationPage;

const useStyles = makeStyles((theme) => ({}));
