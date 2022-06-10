import React from "react";
import { Divider, makeStyles } from "@material-ui/core";

const ruleNames = {
  rules: "House's rules",
  healthAndSecurity: "Health and security",
  cancellationPolicy: "Cancellation policy",
};
const accommodation = {
  info: {
    rules: [
      "Check-in: De 08:00 a 19:00",
      "No apto para niños o bebés",
      "No se permiten fiestas ni eventos",
    ],
    healthAndSecurity: [
      "Se aplican las prácticas de seguridad de Airbnb relacionadas con el COVID-19",
      "Lago, río u otro cuerpo de agua cercano",
    ],
    cancellationPolicy: [
      "Si cancelás antes del 5 jun., vas a obtener un reembolso parcial.",
      "Consultá la política de cancelación completa del anfitrión, que se aplica incluso si cancelás por contagio o algún otro problema causado por el COVID-19.",
    ],
  },
};

const Rules = (/* { accommodation } */) => {
  const classes = useStyles();
  return (
    <section className={classes.section}>
      <h2>What do you have to know</h2>
      <Divider className={classes.divider} />
      <div className={classes.wrapper}>
        {accommodation.info &&
          Object.entries(accommodation.info).map(([ruleType, rules]) => (
            <div className={classes.ruleContainer}>
              <h4>{ruleNames[ruleType]}</h4>
              {rules.map((rule) => (
                <p>{rule}</p>
              ))}
            </div>
          ))}
      </div>
    </section>
  );
};

export default Rules;

const useStyles = makeStyles((theme) => ({
  section: {
    width: "100%",
    padding: "20px 0",
    "& > h2": {
      padding: "0 40px",
    },
  },
  divider: {
    margin: "10px",
    backgroundColor: theme.palette.primary.main,
  },
  wrapper: {
    marginTop: "20px",
    padding: "0px 40px",
    display: "flex",
    justifyContent: "space-between",
    alignItems: "start",
    flexWrap: "wrap",
    gap: "15px",
  },
  ruleContainer: {
    width: "32%",
    "& > h4": {
      marginBottom: "15px",
      fontSize: "20px",
      color: theme.palette.secondary.main,
    },
    "& > p": {
      margin: "10px 0",
    },
    "@media (max-width:830px)": {
      width: "45%",
    },
    "@media (max-width:500px)": {
      width: "100%",
    },
  },
}));
