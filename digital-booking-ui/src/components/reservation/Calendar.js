import React, { useState, useEffect } from "react";
import DatePicker from "react-datepicker";
import { registerLocale } from "react-datepicker";
import es from "date-fns/locale/es";
import { makeStyles } from "@material-ui/core";
import SectionWrapper from "./SectionWrapper";
import { useCurrentWidth } from "../../hooks/useRezise";
import { useReservationStore } from "../../stores/reservation";

registerLocale("es", es);

const Calendar = () => {
  const classes = useStyles();
  const calendarClasses = useCalendarStyles();
  const widthScreen = useCurrentWidth();
  const setDateRange = useReservationStore((s) => s.setDateRange);
  const dateRange = useReservationStore((s) => s.dateRange);
  const [startDate, endDate] = dateRange;
  const today = new Date();

  console.log(dateRange);

  useEffect(() => {
    setDateRange([null, null]);
  }, []);

  const handleSelection = (dates) => {
    setDateRange(dates);
  };
  return (
    <SectionWrapper>
      <h2>Select the reservation date</h2>
      <div className={classes.calendar}>
        <DatePicker
          showPopperArrow={false}
          locale="es"
          placeholderText="Check in - Check out"
          selected={startDate}
          selectsRange={true}
          monthsShown={widthScreen > 500 ? 2 : 1}
          dateFormat="dd 'de' MMM. 'de' yyyy"
          closeOnScroll={false}
          minDate={today}
          onChange={(dates) => handleSelection(dates)}
          startDate={startDate}
          endDate={endDate}
          inline
        />
      </div>
    </SectionWrapper>
  );
};

export default Calendar;

const useStyles = makeStyles((theme) => ({
  container: {
    padding: "30px 20px",
    "& > h2": {
      marginBottom: "15px",
    },
  },
  calendar: {
    textAlign: "center",
    "& .react-datepicker": {
      width: "100%",
      height: "270px",
      ...theme.mixins.cardShadow,
    },
    "& .react-datepicker__month-container": {
      width: "50%",
      "@media (max-width:500px)": {
        width: "100%",
      },
    },
  },
}));

const useCalendarStyles = makeStyles((theme) => ({
  //   wrapper: {
  //     // width: "1000%",
  //     border: "2px solid red",
  //     width: "50%",
  //     "& > div": {
  //       width: "100%",
  //     },
  //     "@media (max-width:500px)": {
  //       width: "100%",
  //       "& .react-datepicker": {
  //         display: "flex",
  //         flexDirection: "column",
  //         width: "95vw",
  //       },
  //     },
  //     "& .react-datepicker": {
  //       width: "100%",
  //     },
  //     "& .react-datepicker__triangle": {
  //       // "&::after": {
  //       //   borderBottomColor: `8px solid red`,
  //       // },
  //     },
  //     "& .react-datepicker__header": {
  //       backgroundColor: theme.palette.primary.main,
  //     },
  //     "& .react-datepicker__current-month": {
  //       color: theme.palette.white,
  //     },
  //     "& .react-datepicker__day-name": {
  //       color: theme.palette.white,
  //     },
  //     "& .react-datepicker__navigation": {
  //       // backgroundColor: theme.palette.primary.main,
  //       borderRadius: "100%",
  //       "&:hover": {
  //         transform: "scale(1.1)",
  //       },
  //     },
  //   },

  calendar: {
    // height: "56px",
    // width: "100%",
    // padding: "10px",
    // borderRadius: "5px",
    // position: "relative",
    // border: "none",
  },
  //   icon: {
  //     position: "absolute",
  //     left: 0,
  //   },
}));
