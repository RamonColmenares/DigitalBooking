import React from "react";
import AcUnitIcon from "@material-ui/icons/AcUnit";
import KitchenIcon from "@material-ui/icons/Kitchen";
import WifiIcon from "@material-ui/icons/Wifi";
import PetsIcon from "@material-ui/icons/Pets";
import PoolIcon from "@material-ui/icons/Pool";
import TvIcon from "@material-ui/icons/Tv";
import DriveEtaIcon from "@material-ui/icons/DriveEta";
import SmokingRoomsIcon from "@material-ui/icons/SmokingRooms";
import SmokeFreeIcon from "@material-ui/icons/SmokeFree";
import { makeStyles } from "@material-ui/core";

const SERVICES = {
  ac: {
    icon: <AcUnitIcon />,
    text: "A/C",
  },
  kitchen: {
    icon: <KitchenIcon />,
    text: "Kitchen",
  },
  wifi: {
    icon: <WifiIcon />,
    text: "WIFI",
  },
  petFriendly: {
    icon: <PetsIcon />,
    text: "Pet friendly",
  },
  pool: {
    icon: <PoolIcon />,
    text: "Pool",
  },
  tv: {
    icon: <TvIcon />,
    text: "TV",
  },
  parking: {
    icon: <DriveEtaIcon />,
    text: "Free parking",
  },
  smoking: {
    icon: <SmokingRoomsIcon />,
    text: "Smoking allowed",
  },
  noSmoking: {
    icon: <SmokeFreeIcon />,
    text: "No smoking",
  },
};

export const ServiceDisplayer = ({ service }) => {
  const classes = useStyles();

  return (
    <div className={classes.wrapper}>
      {SERVICES[service].icon}
      <p>{SERVICES[service].text}</p>
    </div>
  );
};

const useStyles = makeStyles((theme) => ({
  wrapper: {
    display: "flex",
    alignItems: "center",
    gap: "10px",
    width: "24%",
    "& :nth-child(1)": {
      color: theme.palette.primary.main,
    },
    "@media (max-width:1200px)": {
      width: "30%",
    },
    "@media (max-width:600px)": {
      width: "45%",
    },
  },
}));
