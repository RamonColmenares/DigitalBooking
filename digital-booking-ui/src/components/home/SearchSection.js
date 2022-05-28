import React from "react";
import { Button, makeStyles, TextField } from "@material-ui/core";
import { Autocomplete } from "@material-ui/lab";
import Calendar from "./Calendar";
import { registerLocale } from "react-datepicker";
import es from "date-fns/locale/es";
import "react-datepicker/dist/react-datepicker.css";
import { useCitiesStore } from "../../stores/cities";

//DatePicker Configuration in Spanish
registerLocale("es", es);

const SearchSection = () => {
  const classes = useStyles();

  const { data } = useCitiesStore((s) => s.data);

  return (
    <section className={classes.section}>
      <h2>Look for offers on hotels, houses and much more</h2>
      <form className={classes.wrapper} onSubmit={(e) => e.preventDefault()}>
        <div className={classes.div}>
          <Autocomplete
            id="combo-box-demo"
            options={data || []}
            getOptionLabel={(option) => option && option.city}
            classes={{
              inputRoot: classes.autocomplete,
            }}
            renderInput={(params) => (
              <TextField
                {...params}
                label="Where we go?"
                variant="filled"
                className={classes.inputCity}
              />
            )}
          />
        </div>
        <Calendar />
        <Button
          className={classes.submit}
          type="submit"
          variant="contained"
          color="primary"
        >
          Search
        </Button>
      </form>
    </section>
  );
};

export default SearchSection;

const useStyles = makeStyles((theme) => ({
  section: {
    width: "100%",
    backgroundColor: theme.palette.secondary.main,
    minHeight: "150px",
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    "& > h2": {
      fontSize: "36px",
      color: theme.palette.white,
      textAlign: "center",
      padding: "15px",
    },
  },
  wrapper: {
    display: "flex",
    alignItems: "center",
    justifyContent: "center",
    gap: "20px",
    padding: "15px",
    width: "100%",
    "@media (max-width:500px)": {
      flexDirection: "column",
    },
  },
  div: {
    width: "30%",
    "@media (max-width:500px)": {
      width: "100%",
    },
  },
  autocomplete: {
    backgroundColor: theme.palette.white,
  },
  inputCity: {
    backgroundColor: theme.palette.white,
    borderRadius: "5px",
  },
  submit: {
    color: theme.palette.white,
    fontWeight: "bold",
    fontSize: "16px",
    height: "52px",
    width: "20%",
    "@media (max-width:500px)": {
      width: "100%",
    },
  },
}));
