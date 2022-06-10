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
import Rules from "../../components/accomodation/Rules";
import CalendarReservations from "../../components/accomodation/CalendarReservations";
import { useParams } from "react-router-dom";

const AccommodationPage = () => {
  const { id } = useParams();
  const classes = useStyles();
  const navigate = useNavigate();

  const accommodation = useAccommodationStore((s) => s.data);
  const loading = useAccommodationStore((s) => s.loading);
  const loaded = useAccommodationStore((s) => s.loaded);
  const error = useAccommodationStore((s) => s.error);
  const fetchData = useAccommodationStore((s) => s.fetchData);

  useEffect(() => {
    fetchData(id);
  }, []);

  if (error) {
    return <CenterContainer>{/* <ErrorSplash /> */}</CenterContainer>;
  }

  return (
    <>
      {!Object.values(accommodation).length > 0 ? (
        <h1>Loading..</h1>
      ) : (
        <>
          <HeaderAccommodation accommodation={accommodation} />
          <LocationSection accommodation={accommodation} />
          <LikeAndShareSection />
          <Gallery accommodation={accommodation} />
          <DescriptionSection accommodation={accommodation} />
          <ServicesSection accommodation={accommodation} />
          <Rules /* accommodation={accommodation} */ />
          <CalendarReservations />
        </>
      )}
    </>
  );
};

export default AccommodationPage;

const useStyles = makeStyles((theme) => ({}));
