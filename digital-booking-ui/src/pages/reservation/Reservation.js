import React, { useEffect } from "react";
import { makeStyles } from "@material-ui/core";
import HeaderAccommodation from "../../components/accomodation/HeaderAccommodation";
import Rules from "../../components/accomodation/Rules";
import Calendar from "../../components/reservation/Calendar";
import CheckInSection from "../../components/reservation/CheckInSection";
import FormReservation from "../../components/reservation/FormReservation";
import ReservationDetail from "../../components/reservation/ReservationDetail";
import { useAuthStore } from "../../stores/auth";
import { useReservationStore } from "../../stores/reservation";

const Reservation = () => {
  const classes = useStyles();

  const authValues = useAuthStore((s) => s.getValues());

  const setDefaultValues = useReservationStore((s) => s.setDefaultValues);
  const reservationName = useReservationStore((s) => s.name);

  useEffect(() => {
    setDefaultValues(authValues);
  }, []);

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
