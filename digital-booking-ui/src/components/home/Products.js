import React, { useEffect } from "react";
import { Button, makeStyles, Tooltip } from "@material-ui/core";
import { Skeleton } from "@material-ui/lab";
import { useProductsStore } from "../../stores/products";
import StarRateIcon from "@material-ui/icons/StarRate";

import LocationDisplayer from "../../common/Displayers/LocationDisplayer";
import { ServicesDisplayer } from "../../common/Displayers/ServicesDisplayer";

const CATEGORY = {
  Hotels: "Hotel",
  Departments: "Department",
  Hostels: "Hostel",
  "Bed and Breakfast": "Bed and Breakfast",
};

const Products = () => {
  const classes = useStyles();
  const products = useProductsStore((s) => s.data);
  const loading = useProductsStore((s) => s.loading);
  const loaded = useProductsStore((s) => s.loaded);
  const fetchProducts = useProductsStore((s) => s.fetchData);

  useEffect(() => {
    fetchProducts();
  }, [fetchProducts]);

  return (
    <section className={classes.section}>
      <h2>Recommendations</h2>
      <div className={classes.cardWrapper}>
        {products && loaded ? (
          products.map((product) => (
            <ProductCard
              key={product.id}
              className={classes.productCard}
              {...product}
            />
          ))
        ) : (
          <SkeletonCategoryCards />
        )}
      </div>
    </section>
  );
};

const ProductCard = ({
  id,
  title,
  description,
  crimg,
  category,
  location,
  className,
}) => (
  <div className={className}>
    <img src={crimg} alt={title} className="card-img" />
    <div className="card-text">
      <div className="upper-card">
        <div className="category-wrapper">
          <p className="category">{CATEGORY[category]}</p>
          <StarRates />
        </div>
        <Tooltip title={title} arrow>
          <h3 className="title">{title}</h3>
        </Tooltip>
        <LocationDisplayer />
        <ServicesDisplayer />
      </div>
      <div className="bottom-card">
        <p className="description">{description}</p>
        <Button
          className="button-details"
          type="submit"
          variant="contained"
          color="primary"
        >
          DETAILS
        </Button>
      </div>
    </div>
  </div>
);

const StarRates = () => {
  return (
    <>
      <StarRateIcon className="star" /> <StarRateIcon className="star" />{" "}
      <StarRateIcon className="star" /> <StarRateIcon className="star" />
      <StarRateIcon className="star" />
    </>
  );
};

const SkeletonCategoryCards = () => {
  const classes = useStyles();
  return (
    <>
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={"20vw"}
        height={300}
      />
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={"20vw"}
        height={300}
      />
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={"20vw"}
        height={300}
      />
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={"20vw"}
        height={300}
      />
    </>
  );
};

export default Products;

const useStyles = makeStyles((theme) => ({
  section: {
    padding: "30px 40px",
    "& > h2": {
      marginBottom: "15px",
    },
  },
  cardWrapper: {
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
    gap: "15px",
    flexWrap: "wrap",
    "@media (max-width:490px)": {
      flexDirection: "column",
    },
  },
  productCard: {
    display: "flex",
    width: "49%",
    borderRadius: "10px",
    ...theme.mixins.cardShadow,
    cursor: "pointer",
    "&:hover": {
      transform: "scale(1.02)",
    },
    "@media (max-width:1200px)": {
      width: "100%",
    },
    "@media (max-width:600px)": {
      flexDirection: "column",
    },
    "& .card-img": {
      objectFit: "cover",
      width: "300px",
      height: "300px",
      borderRadius: "10px",
      "@media (max-width:600px)": {
        width: "100%",
      },
    },
    "& .card-text": {
      padding: "15px",
      width: "100%",
      display: "flex",
      flexDirection: "column",
      justifyContent: "space-between",
    },
    "& .category-wrapper": {
      display: "flex",
      alignItems: "center",
    },
    "& .category": {
      color: theme.palette.text.hint,
    },
    "& .star": {
      color: theme.palette.primary.main,
    },
    "& .title": {
      fontSize: "24px",
      width: "90%",
      ...theme.mixins.textClamp(2),
    },
    "& .description": {
      ...theme.mixins.textClamp(3),
      marginBottom: "15px",
      paddingRight: "5px",
    },
    "& .button-details": {
      color: theme.palette.white,
      width: "100%",
      fontWeight: "bold",
    },

    // "@media (max-width:1200px)": {
    //   width: "45%",
    // },
    // "@media (max-width:490px)": {
    //   width: "100%",
    // },
  },

  skeletonCard: {
    borderRadius: "10px",
    width: "100%",
  },
}));
