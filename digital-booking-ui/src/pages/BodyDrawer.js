import React from "react";
import {
  Divider,
  List,
  ListItem,
  ListItemIcon,
  ListItemText,
  makeStyles,
} from "@material-ui/core";
import AccountBoxIcon from "@material-ui/icons/AccountBox";
import { Link } from "react-router-dom";

const LINKS = [
  { text: "Log In", link: "/login" },
  { text: "Sign Up", link: "/signup" },
];

const BodyDrawer = () => {
  const classes = useStyles();
  return (
    <div className={classes.body}>
      <List>
        {LINKS.map((anchor) => (
          <div key={anchor.text}>
            <Link to={anchor.link} className={classes.link}>
              <ListItem button>
                <ListItemIcon>
                  <AccountBoxIcon />
                </ListItemIcon>
                <ListItemText>{anchor.text}</ListItemText>
              </ListItem>
            </Link>
            <Divider />
          </div>
        ))}
      </List>
    </div>
  );
};

export default BodyDrawer;

const useStyles = makeStyles((theme) => ({
  body: {
    height: "75%",
  },
  link: {
    color: theme.palette.secondary.dark,
  },
}));
