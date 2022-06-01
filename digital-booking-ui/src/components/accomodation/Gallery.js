import { makeStyles } from "@material-ui/core";
import React from "react";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";

const IMAGES = [
  "https://a0.muscache.com/im/pictures/miso/Hosting-53808720/original/b7a48e0e-4fab-429a-8aca-6205e09ab7a4.jpeg?im_w=960",
  "https://a0.muscache.com/im/pictures/miso/Hosting-53808720/original/f371927c-2db1-4028-a7f7-d586940ffc20.jpeg?im_w=720",
  "https://a0.muscache.com/im/pictures/miso/Hosting-53808720/original/ca97d5a6-6a83-420b-8d93-90a1c298d5e7.jpeg?im_w=1200",
  "https://a0.muscache.com/im/pictures/miso/Hosting-53808720/original/d8446526-ea7e-498e-bfc9-77eb92b14ca3.jpeg?im_w=720",
  "https://a0.muscache.com/im/pictures/miso/Hosting-53808720/original/96b07f65-a23a-4d62-ac6a-6cf9bb674549.jpeg?im_w=1200",
  "https://a0.muscache.com/im/pictures/miso/Hosting-53808720/original/bc31a076-a16e-4c13-b272-74197db30e3d.jpeg?im_w=1200",
  "https://a0.muscache.com/im/pictures/miso/Hosting-53808720/original/35ed7450-63a3-4ed6-a3e8-2b9a4cc8a0f4.jpeg?im_w=720",
];

const responsive = {
  0: { items: 1 },
  568: { items: 1 },
  1024: { items: 2 },
};

const Gallery = () => {
  const classes = useStyles();
  const imgs = IMAGES.map((img) => (
    <div className={classes.imgWrapper}>
      <img className={classes.img} src={img} alt="test" draggable="false" />
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
    margin: "0px 5px"
  }
}));
