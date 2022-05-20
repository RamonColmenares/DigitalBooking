import { Button, makeStyles, TextField } from "@material-ui/core";
import React from "react";
import { Link } from "react-router-dom";
import {
  ConfirmPassword,
  Email,
  Name,
  Password,
  Surname,
} from "../../common/inputs/formInputs";
import { useSignUpStore } from "../../stores/signUp";
import FormWrapper from "./FormWrapper";

const SignUp = () => {
  const classes = useStyles();
  const name = useSignUpStore((s) => s.name);
  const setName = useSignUpStore((s) => s.setName);
  const surname = useSignUpStore((s) => s.surname);
  const setSurname = useSignUpStore((s) => s.setSurname);
  const email = useSignUpStore((s) => s.email);
  const setEmail = useSignUpStore((s) => s.setEmail);
  const password = useSignUpStore((s) => s.password);
  const setPassword = useSignUpStore((s) => s.setPassword);
  const password2 = useSignUpStore((s) => s.password2);
  const setPassword2 = useSignUpStore((s) => s.setPassword2);

  console.log({ name });

  return (
    <FormWrapper>
      <form className={classes.form}>
        <h2>Create Account</h2>
        <div className={classes.namesWrapper}>
          <Name value={name} onChange={setName} />
          <Surname value={surname} onChange={setSurname} />
        </div>
        <Email value={email} onChange={setEmail} />
        <Password value={password} onChange={setPassword} />
        <ConfirmPassword value={password2} onChange={setPassword2} />
        <Button
          type="submit"
          className={classes.button}
          variant="contained"
          color="primary"
        >
          Create Account
        </Button>
        <p className={classes.toLogin}>
          Already have an account?<Link to="/login">Log In</Link>
        </p>
      </form>
    </FormWrapper>
  );
};

export default SignUp;

const useStyles = makeStyles((theme) => ({
  form: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    width: "80%",
    margin: "0 auto",
    "& > h2": {
      color: theme.palette.primary.main,
      fontWeight: "bold",
    },
  },
  namesWrapper: {
    display: "flex",
    width: "50%" /* 220px */,
    margin: "18px 0",
    gap: "20px",
    "& > :nth-child(1)": {
      flexGrow: 1,
    },
    "& > :nth-child(2)": {
      flexGrow: 1,
    },
  },
  textField: {
    width: "50%",
    margin: "18px 0",
  },
  button: {
    color: theme.palette.white,
    fontWeight: "bold",
  },
  toLogin: {
    marginTop: "18px",
    "& > a": {
      margin: "0 10px",
      color: theme.palette.primary.main,
    },
  },
}));
