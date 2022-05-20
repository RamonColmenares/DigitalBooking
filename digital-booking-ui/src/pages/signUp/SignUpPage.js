import { Button, makeStyles } from "@material-ui/core";
import { Alert } from "@material-ui/lab";
import React from "react";
import { Link, useNavigate } from "react-router-dom";
import {
  ConfirmPassword,
  Email,
  Name,
  Password,
  Surname,
} from "../../common/inputs/formInputs";
import { useSignUpStore } from "../../stores/signUp";
import FormWrapper from "../../components/auth/FormWrapper";

const SignUpPage = () => {
  const classes = useStyles();

  const navigate = useNavigate();

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
  const error = useSignUpStore((s) => s.error);
  const setError = useSignUpStore((s) => s.setError);
  const resetState = useSignUpStore((s) => s.resetState);

  useEffect(() => {
    return () => resetState();
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (password.trim().length < 6 || password2.trim().length < 6) {
      setError("The password should be longer than 6");
      return;
    }
    if (password !== password2) {
      setError("The passwords should match");
      return;
    }
    //Validate Email

    // resetState();
    navigate("/login");
  };

  return (
    <FormWrapper>
      <form className={classes.form} onSubmit={handleSubmit}>
        <h2>Create Account</h2>
        <div className={classes.namesWrapper}>
          <Name value={name.value} onChange={setName} />
          <Surname value={surname.value} onChange={setSurname} />
        </div>
        <Email value={email.value} onChange={setEmail} />
        <Password value={password.value} onChange={setPassword} />
        <ConfirmPassword value={password2.value} onChange={setPassword2} />
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
        <div className={classes.errorWrapper}>
          {error && <Alert severity="error">{error}</Alert>}
        </div>
      </form>
    </FormWrapper>
  );
};

export default SignUpPage;

const useStyles = makeStyles((theme) => ({
  form: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    width: "50%",
    margin: "0 auto",
    "@media (max-width:800px)": {
      width: "90%",
    },
    "& > h2": {
      color: theme.palette.primary.main,
      fontWeight: "bold",
      marginBottom: "12px",
    },
  },
  namesWrapper: {
    display: "flex",
    // width: "50%" /* 220px */,
    width: "100%",
    margin: "18px 0",
    gap: "20px",
    "& > :nth-child(1)": {
      flexGrow: 1,
    },
    "& > :nth-child(2)": {
      flexGrow: 1,
    },
    "@media (max-width:800px)": {
      flexDirection: "column",
    },
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
  errorWrapper: {
    height: "20px",
    marginTop: "16px",
  },
}));
