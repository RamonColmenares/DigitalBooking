import React from "react";
import { makeStyles } from "@material-ui/core";
import Avatar from "@material-ui/core/Avatar";

const User = ({ name, surname, navbar = false }) => {
  const classes = useUserStyles({ navbar });
  const fullName = `${name} ${surname}`;
  const alias = `${name.charAt(0)}${surname.charAt(0)}`;

  return (
    <div className={classes.userWrapper}>
      <Avatar alt={fullName}>{alias.toUpperCase()}</Avatar>
      <div>
        <p>
          Hola, <br /> <span>{fullName}</span>
        </p>
      </div>
    </div>
  );
};

export default User;

const useUserStyles = makeStyles((theme) => ({
  userWrapper: {
    display: "flex",
    gap: "10px",
    fontWeight: "bold",
    "& span": {
      color: ({ navbar }) =>
        navbar ? theme.palette.primary.main : theme.palette.white,
    },
    "@media (max-width:800px)": {
      display: ({ navbar }) => (navbar ? "none" : ""),
    },
  },
}));
