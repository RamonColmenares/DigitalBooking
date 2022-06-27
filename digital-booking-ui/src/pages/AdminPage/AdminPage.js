import { makeStyles, MenuItem, TextField } from "@material-ui/core";
import React from "react";
import HeaderAccommodation from "../../components/accomodation/HeaderAccommodation";
import BasicData from "../../components/admin/BasicData";
import ServiceForm from "../../components/admin/ServiceForm";
import SectionWrapper from "../../components/reservation/SectionWrapper";
import { CATEGORIES } from "../../models/business/categories";
import { useAdminStore } from "../../stores/admin";
import { useCitiesStore } from "../../stores/cities";

const AdminPage = () => {
  const classes = useStyles();

  return (
    <>
      <HeaderAccommodation isAdmin />
      <section className={classes.section}>
        <h2>Create Accommodation</h2>
        <form className={classes.form}>
          <BasicData />
          <ServiceForm />
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
}));
