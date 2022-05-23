import { makeStyles } from "@material-ui/core";
import { Skeleton } from "@material-ui/lab";
import React, { useEffect } from "react";
import { useCategoriesStore } from "../../stores/categories";

const Categories = () => {
  const classes = useStyles();
  const categories = useCategoriesStore((s) => s.data);
  const loading = useCategoriesStore((s) => s.loading);
  const loaded = useCategoriesStore((s) => s.loaded);
  const fetchCategories = useCategoriesStore((s) => s.fetchData);

  useEffect(() => {
    fetchCategories();
  }, [fetchCategories]);

  return (
    <section className={classes.section}>
      <h2>Search by Category</h2>
      <div className={classes.cardWrapper}>
        {categories && loaded ? (
          categories.map((category) => (
            <CategoryCard
              key={category.id}
              className={classes.card}
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

const CategoryCard = ({ id, title, description, img, className }) => (
  <div className={className}>
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
        width={430}
        height={250}
      />
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={430}
        height={250}
      />
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={430}
        height={250}
      />
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={430}
        height={250}
      />
    </>
  );
};

export default Categories;

const useStyles = makeStyles((theme) => ({
  section: {
    margin: "30px 0",
    "& > h2": {
      marginBottom: "15px",
    },
  },
  cardWrapper: {
    display: "flex",
    alignItems: "center",
    gap: "15px",
    flexWrap: "wrap",
  },
  card: {
    width: "430px",
    borderRadius: "10px",
    ...theme.mixins.cardShadow,
    cursor: "pointer",
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
  },
  skeletonCard: {
    borderRadius: "10px",
  },
}));
