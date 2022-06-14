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
  const setError = useReservationStore((s) => s.setError);
  const errorDates = useReservationStore((s) => s.getErrorDates());
  const dateRange = useReservationStore((s) => s.dateRange);

  useEffect(() => {
    setDefaultValues(authValues);
  }, []);

  const getFormValues = useReservationStore((s) => s.getFormValues);

  const handleSubmitReservation = (e) => {
    setError("");
    e.preventDefault();
    console.log({ dateRange });
    console.log({ errorDates });
    console.log(getFormValues());
    if (errorDates) {
      setError("You must choose the Check In and Check Out dates");
      return;
    }
  };

  return (
    <>
      {/* <HeaderAccommodation accommodation={} /> */}
      <form className={classes.container} onSubmit={handleSubmitReservation}>
        <div className="left-side">
          <FormReservation />
          <Calendar />
          <CheckInSection />
        </div>
        <ReservationDetail />
      </form>
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
