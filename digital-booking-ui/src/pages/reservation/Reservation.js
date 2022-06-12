import { makeStyles } from "@material-ui/core";
import React from "react";
import HeaderAccommodation from "../../components/accomodation/HeaderAccommodation";
import Rules from "../../components/accomodation/Rules";
import Calendar from "../../components/reservation/Calendar";
import CheckInSection from "../../components/reservation/CheckInSection";
import FormReservation from "../../components/reservation/FormReservation";
import ReservationDetail from "../../components/reservation/ReservationDetail";

const Reservation = () => {
  const classes = useStyles();
  return (
    <>
      {/* <HeaderAccommodation accommodation={} /> */}
      <div className={classes.container}>
        <div className="left-side">
          <FormReservation />
          <Calendar />
          <CheckInSection />
        </div>
        <ReservationDetail />
      </div>
      <Rules />
    </>
  );
};

export default Reservation;

const useStyles = makeStyles((theme) => ({
  container: {
    display: "flex",
    gap: "30px",
    padding: "40px 40px",
    "& > :nth-child(1)": {
      flexGrow: 1,
      display: "flex",
      flexDirection: "column",
      justifyContent: "space-between",
    },
    "@media (max-width:930px)": {
      padding: "30px 10px",
    },
  },
}));
