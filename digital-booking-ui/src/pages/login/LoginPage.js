import { Button, makeStyles } from "@material-ui/core";
import { Alert } from "@material-ui/lab";
import React, { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import { Email, Password } from "../../common/inputs/formInputs";
import FormWrapper from "../../components/auth/FormWrapper";
import { useLoginStore } from "../../stores/login";
import { useSignUpStore } from "../../stores/signUp";

const LoginPage = () => {
  const classes = useStyles();

  const navigate = useNavigate();

  const email = useLoginStore((state) => state.email);
  const setEmail = useLoginStore((state) => state.setEmail);
  const password = useLoginStore((state) => state.password);
  const setPassword = useLoginStore((state) => state.setPassword);
  const error = useLoginStore((state) => state.error);
  const setError = useLoginStore((state) => state.setError);
  const resetState = useLoginStore((state) => state.resetState);

  const emailSignUp = useSignUpStore((s) => s.email);
  const passwordSignUp = useSignUpStore((s) => s.password);

  useEffect(() => {
    return () => resetState();
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    if (email.trim() !== emailSignUp.trim()) {
      setError("The email doesn't exist");
      return;
    }
    if (password.trim() !== passwordSignUp.trim()) {
      setError("Invalid password");
      return;
    }

    navigate("/");
  };

  return (
    <FormWrapper>
      <form className={classes.form} onSubmit={handleSubmit}>
        <h2 className="text">Log In</h2>
        <Email value={email} onChange={setEmail} />
        <Password value={password} onChange={setPassword} />
        <Button
          type="submit"
          variant="contained"
          color="primary"
          className={classes.button}
        >
          Log In
        </Button>
        <p className={classes.toSignup}>
          Don't have an account yet?<Link to="/signup">Sign Up</Link>
        </p>
        <div className={classes.errorWrapper}>
          {error && <Alert severity="error">{error}</Alert>}
        </div>
      </form>
    </FormWrapper>
  );
};

export default LoginPage;

const useStyles = makeStyles((theme) => ({
  form: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    width: "50%",
    margin: "0 auto",
    "& > h2": {
      color: theme.palette.primary.main,
      fontWeight: "bold",
      marginBottom: "12px",
    },
  },
  button: {
    color: theme.palette.white,
    fontWeight: "bold",
  },
  toSignup: {
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
