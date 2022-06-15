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
import { useAccommodationStore } from "../../stores/accommodation";
import { useParams } from "react-router-dom";

const Reservation = () => {
  const classes = useStyles();
  const { id } = useParams();

  const authValues = useAuthStore((s) => s.getValues());

  const accommodation = useAccommodationStore((s) => s.data);
  const fetchData = useAccommodationStore((s) => s.fetchData);

  const setDefaultValues = useReservationStore((s) => s.setDefaultValues);
  const setError = useReservationStore((s) => s.setError);
  const errorDates = useReservationStore((s) => s.getErrorDates());
  const dateRange = useReservationStore((s) => s.dateRange);

  useEffect(() => {
    setDefaultValues(authValues);
    fetchData(id);
  }, []);

  const getFormValues = useReservationStore((s) => s.getFormValues);

  const handleSubmitReservation = (e) => {
    setError("");
    e.preventDefault();
    if (errorDates) {
      setError("You must choose the Check In and Check Out dates");
      return;
    }
  };

  return (
    <>
      {!Object.values(accommodation).length > 0 ? (
        <h1>Loading..</h1>
      ) : (
        <>
          <HeaderAccommodation accommodation={accommodation} />
          <form
            className={classes.container}
            onSubmit={handleSubmitReservation}
          >
            <div className="left-side">
              <FormReservation />
              <Calendar />
              <CheckInSection />
            </div>
            <ReservationDetail accommodation={accommodation} />
          </form>
          <Rules policies={accommodation.policies} />
        </>
      )}
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
