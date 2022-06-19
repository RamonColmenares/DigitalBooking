import React, { useEffect } from "react";
import { Button, makeStyles, Tooltip } from "@material-ui/core";
import { Rating, Skeleton } from "@material-ui/lab";
import LocationDisplayer from "../../common/Displayers/LocationDisplayer";
import { useNavigate } from "react-router-dom";

import { useProductsStore } from "../../stores/products";
import { ServicesSection } from "./ServicesSection";
import { CATEGORIES } from "../../models/business/categories";

const Products = () => {
  const classes = useStyles();
  const products = useProductsStore((s) => s.data);
  const loading = useProductsStore((s) => s.loading);
  const loaded = useProductsStore((s) => s.loaded);
  const clearFilters = useProductsStore((s) => s.clearFilter);
  const fetchProducts = useProductsStore((s) => s.fetchData);
  const navigate = useNavigate();

  const handleGoAccommodation = (id) => {
    navigate(`/accommodation/${id}`);
  };

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
              onClick={handleGoAccommodation}
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
  name,
  description,
  imageUrl,
  category,
  city,
  className,
  onClick,
}) => (
  <div className={className} key={id}>
    <img src={imageUrl} alt={name} className="card-img" />
    <div className="card-text">
      <div className="upper-card">
        <div className="category-wrapper">
          <p className="category">{CATEGORIES[category.title]}</p>
          <Rating name="rating" size="small" />
          <div className="punctuation">
            <div className="number">
              <p>8</p>
            </div>
            <p>Very Good</p>
          </div>
        </div>
        <Tooltip title={name} arrow>
          <h3 className="title">{name}</h3>
        </Tooltip>
        <LocationDisplayer city={city} />
        <ServicesSection />
      </div>
      <div className="bottom-card">
        <p className="description">{description}</p>
        <Button
          className="button-details"
          type="submit"
          variant="contained"
          color="primary"
          onClick={() => onClick(id)}
        >
          DETAILS
        </Button>
      </div>
    </div>
  </div>
);

const SkeletonCategoryCards = () => {
  const classes = useStyles();
  return (
    <>
      <Skeleton classes={{ root: classes.skeletonCard }} variant="rect" />
      <Skeleton classes={{ root: classes.skeletonCard }} variant="rect" />
      <Skeleton classes={{ root: classes.skeletonCard }} variant="rect" />
      <Skeleton classes={{ root: classes.skeletonCard }} variant="rect" />
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
    "@media (max-width:480px)": {
      padding: "30px 15px",
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
      position: "relative",
    },
    "& .category": {
      color: theme.palette.text.hint,
      marginRight: "10px",
    },
    "& .star": {
      color: theme.palette.primary.main,
    },
    "& .punctuation": {
      position: "absolute",
      right: 0,
      top: 0,
      textAlign: "right",
      "& :nth-child(2)": {
        marginTop: "5px",
        fontWeight: "bold",
      },
      "& .number": {
        display: "flex",
        justifyContent: "end",
        "& > p": {
          backgroundColor: "black",
          color: "white",
          borderRadius: "5px",
          fontSize: "20px",
          fontWeight: "bold",
          padding: "2px 6px",
        },
      },
    },
    "& .title": {
      fontSize: "24px",
      width: "75%",
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
  },

  skeletonCard: {
    borderRadius: "10px",
    width: "47vw",
    height: "300px",
    "@media (max-width:1200px)": {
      width: "100%",
    },
    "@media (max-width:600px)": {
      height: "500px",
    },
  },
}));
