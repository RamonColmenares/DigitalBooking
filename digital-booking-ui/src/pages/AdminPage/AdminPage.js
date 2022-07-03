import { Button, makeStyles } from "@material-ui/core";
import React from "react";
import HeaderAccommodation from "../../components/accomodation/HeaderAccommodation";
import BasicData from "../../components/admin/BasicData";
import ImagesForm from "../../components/admin/ImagesForm";
import PoliciesForm from "../../components/admin/PoliciesForm";
import ServiceForm from "../../components/admin/ServiceForm";

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
          <PoliciesForm />
          <ImagesForm />
          <div className={classes.wrapperButton}>
            <Button
              className={classes.button}
              type="submit"
              variant="contained"
              color="primary"
            >
              Create product
            </Button>
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
    "@media (max-width:480px)": {
      padding: "30px 15px",
    },
  },
  form: {
    padding: "30px 25px",
    "@media (max-width:480px)": {
      padding: "30px 0",
    },
  },
  wrapperButton: {
    textAlign: "center",
    marginTop: "50px",
  },
  button: {
    color: theme.palette.white,
    fontWeight: "bold",
    fontSize: "20px",
  },
}));
