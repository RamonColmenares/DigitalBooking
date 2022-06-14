import React from "react";
import { Button, Divider, makeStyles } from "@material-ui/core";
import { Rating } from "@material-ui/lab";
import LocationDisplayer from "../../common/Displayers/LocationDisplayer";
import { useReservationStore } from "../../stores/reservation";

const ReservationDetail = () => {
  const classes = useStyles();
  const [startDate, endDate] = useReservationStore((s) => s.dateRange);

  return (
    <div className={classes.container}>
      <h2 className="title">Reserve's details</h2>
      <img
        className="img"
        src="https://images.unsplash.com/photo-1618773928121-c32242e63f39"
        alt=""
      />
      <p className="category">HOTEL</p>
      <h3 className="name">Hermitage Hotel</h3>
      <Rating name="rating" size="small" />
      <LocationDisplayer
        city={{ name: "Dubai", name_country: "United Arab Emirates" }}
      />
      <div className="check-wrapper">
        <Divider />
        <div className="check">
          <p>Check In</p>
          <p>{startDate ? startDate.toLocaleDateString() : "- / - / -"}</p>
        </div>
        <Divider />
        <div className="check">
          <p>Check Out</p>
          <p>{endDate ? endDate.toLocaleDateString() : "- / - / -"}</p>
        </div>
        <Divider />
      </div>
      <Button
        className={classes.button}
        color="primary"
        variant="contained"
        type="submit"
      >
        Confirm reservation
      </Button>
    </div>
  );
};

export default ReservationDetail;

const useStyles = makeStyles((theme) => ({
  container: {
    display: "flex",
    flexDirection: "column",
    width: "30vw",
    ...theme.mixins.cardShadow,
    padding: "30px 20px",
    borderRadius: "5px",
    "@media (max-width:930px)": {
      display: "none",
    },
    "& .img": {
      margin: "15px 0 30px 0",
      display: "block",

      minHeight: "360px",
      objectFit: "cover",
      flexShrink: 1,
    },
    "& .category": {
      color: theme.palette.text.hint,
      fontSize: "14px",
    },
    "& .name": {
      margin: "4px 0",
    },
    "& .check-wrapper": {
      margin: "15px 0 25px",
    },
    "& .check": {
      display: "flex",
      alignItems: "center",
      justifyContent: "space-between",
      padding: "25px 0px",
    },
  },
  button: {
    marginTop: "20px",
    color: theme.palette.white,
    fontWeight: "bold",
  },
}));
