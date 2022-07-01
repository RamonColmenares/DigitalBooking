import React from "react";
import { Divider, makeStyles, TextField } from "@material-ui/core";
import SectionWrapper from "../reservation/SectionWrapper";

const POLICIES = ["Health & Security", "Ni idea", "Cancelation policies"];

const PoliciesForm = () => {
  const classes = useStyles();
  return (
    <SectionWrapper>
      <h3>Policies</h3>
      <div className={classes.container}>
        {POLICIES.map((policy) => (
          <PolicyDescription title={policy} className={classes.section} />
        ))}
      </div>
    </SectionWrapper>
  );
};

export default PoliciesForm;

const PolicyDescription = ({ title, className, value, onChange }) => {
  return (
    <div className={className}>
      <h4>{title}</h4>
      <TextField
        className="text-field"
        label="Description"
        multiline
        minRows={8}
        maxRows={8}
        variant="outlined"
        fullWidth
        required
        value={value}
        onChange={(e) => onChange(e.target.value)}
        maxLength={20000}
      />
    </div>
  );
};

const useStyles = makeStyles(() => ({
  container: {
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    flexWrap: "wrap",
    gap: "15px",
  },
  section: {
    flexGrow: 1,
    "& > h4": {
      padding: "20px 0",
    },
    "& .text-field": {
      minWidth: "300px",
    },
  },
}));
