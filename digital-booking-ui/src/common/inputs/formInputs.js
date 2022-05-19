import { makeStyles, TextField } from "@material-ui/core";

export const Name = ({ value, onChange }) => (
  <TextField id="name" label="Name" />
);

export const Surname = ({ value, onChange }) => (
  <TextField id="surname" label="Surname" />
);

export const Email = ({ value, onChange }) => {
  const classes = useStyles();
  return <TextField className={classes.textField} id="email" label="Email" />;
};

export const Password = ({ value, onChange }) => {
  const classes = useStyles();
  return (
    <TextField
      className={classes.textField}
      id="password"
      label="Password"
      type="password"
    />
  );
};

export const ConfirmPassword = ({ value, onChange }) => {
  const classes = useStyles();
  return (
    <TextField
      className={classes.textField}
      id="password2"
      label="Confirm Password"
      type="password"
    />
  );
};

const useStyles = makeStyles(() => ({
  textField: {
    width: "50%",
    margin: "18px 0",
  },
}));
