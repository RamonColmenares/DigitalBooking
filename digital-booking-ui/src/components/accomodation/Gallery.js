import { makeStyles } from "@material-ui/core";
import React from "react";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";

const responsive = {
  0: { items: 1 },
  568: { items: 1 },
  1024: { items: 2 },
};

const Gallery = ({ accommodation: { images } }) => {
  const classes = useStyles();
  const imgs = images.map((img) => (
    <div className={classes.imgWrapper}>
      <img className={classes.img} src={img.url} alt="test" draggable="false" />
    </div>
  ));

  return (
    <div className={classes.gallery}>
      <AliceCarousel
        items={imgs}
        responsive={responsive}
        autoPlay
        autoPlayInterval={3000}
        infinite
        controlsStrategy="alternate"
        mouseTracking
        keyboardNavigation
      />
    </div>
  );
};

export default Gallery;

const useStyles = makeStyles(() => ({
  gallery: {
    padding: "10px 40px",
    "@media (max-width:1000px)": {
      padding: "10px",
    },
  },
  img: {
    height: "400px",
    width: "100%",
    objectFit: "cover",
    border: "2px solid black",
    "@media (max-width:800px)": {
      height: "40vh",
    },
  },
  imgWrapper: {
    margin: "0px 5px",
  },
}));
