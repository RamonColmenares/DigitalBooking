import React from "react";
import WifiIcon from "@material-ui/icons/Wifi";
import PoolIcon from "@material-ui/icons/Pool";
import { makeStyles } from "@material-ui/core";

const SERVICES = {
  pool: PoolIcon,
  wifi: WifiIcon,
};

export const ServicesDisplayer = ({ services }) => {
  const classes = useStyles();
  return (
    <div>
      {Object.values(SERVICES).map((Service) => (
        <Service className={classes.icon} />
      ))}
    </div>
  );
};

const useStyles = makeStyles(() => ({
  icon: {
    marginRight: "5px",
  },
}));
