import { useState } from "react";
import { InputAdornment, makeStyles, TextField } from "@material-ui/core";
import VisibilityIcon from "@material-ui/icons/Visibility";
import VisibilityOffIcon from "@material-ui/icons/VisibilityOff";

export const Name = ({ value, onChange }) => {
  console.log(value);
  return (
    <TextField
      id="name"
      label="Name"
      value={value}
      onChange={({ target }) => onChange(target.value)}
    />
  );
};

export const Surname = ({ value, onChange }) => (
  <TextField
    id="surname"
    label="Surname"
    value={value}
    onChange={({ target }) => onChange(target.value)}
  />
);

export const Email = ({ value, onChange }) => {
  const classes = useStyles();
  return (
    <TextField
      className={classes.textField}
      id="email"
      label="Email"
      value={value}
      onChange={({ target }) => onChange(target.value)}
    />
  );
};

export const Password = ({ value, onChange }) => {
  const classes = useStyles();
  const [visible, setVisible] = useState(false);
  return (
    <TextField
      className={classes.textField}
      id="password"
      label="Password"
      type={visible ? "text" : "password"}
      value={value}
      onChange={({ target }) => onChange(target.value)}
      InputProps={{
        endAdornment: (
          <InputAdornment onClick={() => setVisible((state) => !state)}>
            {visible ? <VisibilityIcon /> : <VisibilityOffIcon />}
          </InputAdornment>
        ),
      }}
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
      value={value}
      onChange={({ target }) => onChange(target.value)}
    />
  );
};

const useStyles = makeStyles(() => ({
  textField: {
    width: "50%",
    margin: "18px 0",
  },
}));
