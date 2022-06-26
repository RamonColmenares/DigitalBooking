import { makeStyles, MenuItem, TextField } from "@material-ui/core";
import React from "react";
import HeaderAccommodation from "../../components/accomodation/HeaderAccommodation";
import SectionWrapper from "../../components/reservation/SectionWrapper";
import { CATEGORIES } from "../../models/business/categories";
import { useCitiesStore } from "../../stores/cities";

const AdminPage = () => {
  const classes = useStyles();
  const cities = useCitiesStore((s) => s.data);
  console.log({ cities });
  return (
    <>
      <HeaderAccommodation isAdmin />
      <section className={classes.section}>
        <h2>Create Accommodation</h2>
        <form className={classes.form}>
          <div className={classes.containerCreate}>
            <div className="input-wrapper">
              <TextField
                label="Name"
                id="name"
                required
                className={classes.textField}
                type="text"
              />
              <TextField
                label="Category"
                id="category"
                className={classes.textField}
                required
                select
              >
                {Object.values(CATEGORIES).map((option) => (
                  <MenuItem key={option} value={option}>
                    {option}
                  </MenuItem>
                ))}
              </TextField>
            </div>
            <div className="input-wrapper">
              <TextField
                label="Address"
                id="address"
                type="text"
                required
                className={classes.textField}
              />
              <TextField
                label="City"
                id="City"
                required
                select
                className={classes.textField}
              >
                {cities.map((option) => (
                  <MenuItem key={option.id} value={option}>
                    {`${option.name}, ${option.name_country}`}
                  </MenuItem>
                ))}
              </TextField>
            </div>
            <div className="input-wrapper">
              <TextField
                label="Latitude"
                id="latitude"
                type="number"
                required
                className={classes.textField}
              />
              <TextField
                label="Longitude"
                id="longitude"
                type="number"
                required
                className={classes.textField}
              />
            </div>
            <TextField
              label="Description"
              multiline
              rows={5}
              maxLength={20000}
            />
          </div>
        </form>
      </section>
    </>
  );
};

export default AdminPage;

const useStyles = makeStyles((theme) => ({
  section: {
    padding: "30px 40px",
  },
  form: {
    padding: "30px 25px",
    border: "2px solid red",
  },
  containerCreate: {
    display: "flex",
    flexDirection: "column",
    "& > .input-wrapper": {
      // width: "100%",
      //   border: "2px solid black",
      margin: "20px 0",
      display: "flex",
      alignItems: "center",
      justifyContent: "space-between",
      gap: "20px",
      "@media (max-width:500px)": {
        flexDirection: "column",
      },
    },
  },
  textField: {
    width: "100%",
  },
}));
