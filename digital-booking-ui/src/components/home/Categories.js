import React, { useEffect } from "react";
import { Button, makeStyles } from "@material-ui/core";
import { Skeleton } from "@material-ui/lab";
import { useCategoriesStore } from "../../stores/categories";
import { useProductsStore } from "../../stores/products";
import BackspaceIcon from "@material-ui/icons/Backspace";

const Categories = () => {
  const classes = useStyles();
  const categories = useCategoriesStore((s) => s.data);
  const loading = useCategoriesStore((s) => s.loading);
  const loaded = useCategoriesStore((s) => s.loaded);
  const fetchCategories = useCategoriesStore((s) => s.fetchData);

  const filterCategory = useProductsStore((s) => s.filterCategory);
  const setFilter = useProductsStore((s) => s.setFilter);
  const clearFilter = useProductsStore((s) => s.clearFilter);

  useEffect(() => {
    fetchCategories();
  }, [fetchCategories]);

  return (
    <section className={classes.section}>
      <div className={classes.titleWrapper}>
        <h2>Search by Category</h2>
        {filterCategory && (
          <Button
            color="secondary"
            variant="contained"
            endIcon={<BackspaceIcon fontSize="small" />}
            onClick={clearFilter}
          >
            Clear Filters
          </Button>
        )}
      </div>
      <div className={classes.cardWrapper}>
        {categories && loaded ? (
          categories.map((category) => (
            <CategoryCard
              key={category.id}
              className={classes.card}
              onClick={setFilter}
              {...category}
            />
          ))
        ) : (
          <SkeletonCategoryCards />
        )}
      </div>
    </section>
  );
};

const CategoryCard = ({ id, title, description, img, onClick, className }) => (
  <div className={className} onClick={() => onClick(title)}>
    <img src={img} alt={title} className="card-img" />
    <div className="card-text">
      <h3>{title}</h3>
      <p>{description}</p>
    </div>
  </div>
);

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

export default Categories;

const useStyles = makeStyles((theme) => ({
  section: {
    padding: "30px 40px",
    "@media (max-width:480px)": {
      padding: "30px 15px",
    },
  },
  titleWrapper: {
    display: "flex",
    alignItems: "center",
    marginBottom: "15px",
    gap: "20px",
    "& > button": {
      // marginBottom: "5px",
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
  card: {
    width: "24%",
    borderRadius: "10px",
    ...theme.mixins.cardShadow,
    cursor: "pointer",
    "&:hover": {
      transform: "scale(1.02)",
    },
    "& .card-img": {
      objectFit: "cover",
      width: "100%",
      borderRadius: "10px 10px 0px 0px",
    },
    "& .card-text": {
      padding: "10px",
      "& > h3": {
        marginBottom: "5px",
      },
    },
    "@media (max-width:1200px)": {
      width: "45%",
    },
    "@media (max-width:490px)": {
      width: "100%",
    },
  },
  skeletonCard: {
    borderRadius: "10px",
    width: "100%",
  },
}));
