import React, { useState, useEffect } from "react";
import { makeStyles } from "@material-ui/core";
import CalendarTodayIcon from "@material-ui/icons/CalendarToday";
import DatePicker from "react-datepicker";
import { registerLocale } from "react-datepicker";
import es from "date-fns/locale/es";
import "react-datepicker/dist/react-datepicker.css";
import "../../index.css";
//DatePicker Configuration in Spanish
registerLocale("es", es);

const Calendar = ({ inline }) => {
  const classes = useStyles();
  const [dateRange, setDateRange] = useState([null, null]);
  const [startDate, endDate] = dateRange;
  const today = new Date();

  useEffect(() => {
    setDateRange([null, null]);
  }, []);

  const handleSelection = (dates) => {
    setDateRange(dates);
  };

  return (
    <div className={classes.wrapper}>
      <DatePicker
        className={classes.calendar}
        locale="es"
        placeholderText="Check in - Check out"
        selected={startDate}
        selectsRange={true}
        monthsShown={2}
        dateFormat="dd 'de' MMM. 'de' yyyy"
        closeOnScroll={true}
        minDate={today}
        onChange={(dates) => handleSelection(dates)}
        startDate={startDate}
        endDate={endDate}
        inline={inline}
      />
      {/* <CalendarTodayIcon className={classes.icon} /> */}
    </div>
  );
};

export default Calendar;

const useStyles = makeStyles((theme) => ({
  wrapper: {
    width: "30%",
    "@media (max-width:500px)": {
      width: "100%",
      "& .react-datepicker": {
        display: "flex",
        flexDirection: "column",
        width: "95vw",
      },
    },
    "& .react-datepicker": {
      color: "white",
      width: "100%",
    },
    "& .react-datepicker__triangle": {
      // "&::after": {
      //   borderBottomColor: `8px solid red`,
      // },
    },
    "& .react-datepicker__header": {
      backgroundColor: theme.palette.primary.main,
    },
    "& .react-datepicker__current-month": {
      color: theme.palette.white,
    },
    "& .react-datepicker__day-name": {
      color: theme.palette.white,
    },
    "& .react-datepicker__navigation": {
      // backgroundColor: theme.palette.primary.main,
      borderRadius: "100%",
      "&:hover": {
        transform: "scale(1.1)",
      },
    },
  },
  calendar: {
    height: "56px",
    width: "100%",
    padding: "0 10px",
    borderRadius: "5px",
    position: "relative",
    border: "none",
  },
  icon: {
    position: "absolute",
    left: 0,
  },
}));
