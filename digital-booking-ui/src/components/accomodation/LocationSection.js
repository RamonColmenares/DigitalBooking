import React from 'react';
import LocationOnIcon from '@material-ui/icons/LocationOn';
import PunctuationDisplayerWithStars from '../../common/Displayers/PunctuationDisplayer';
import { makeStyles } from '@material-ui/core';
import LocationDisplayer from '../../common/Displayers/LocationDisplayer';

const LocationSection = ({ accommodation: { location } }) => {
  const classes = usestyles();
  return (
    <div className={classes.section}>
      <div className={classes.location}>
        <LocationOnIcon />
        <LocationDisplayer city={location} />
      </div>
      <PunctuationDisplayerWithStars />
    </div>
  );
};

export default LocationSection;

const usestyles = makeStyles((theme) => ({
  section: {
    width: '100%',
    height: '55px',
    padding: '40px 40px',
    backgroundColor: theme.palette.secondary.light,
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    '@media (max-width:500px)': {
      padding: '10px',
    },
  },
  location: {
    fontSize: '14px',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    gap: '5px',
  },
}));
