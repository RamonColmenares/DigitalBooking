import { Button, makeStyles } from '@material-ui/core';
import { Skeleton } from '@material-ui/lab';
import React, { useEffect } from 'react';
import { useProductsStore } from '../../stores/products';

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
      <p>{category}</p>
      <h3>{title}</h3>
      <h6>{location}</h6>
      <p>{description}</p>
      <Button type="submit" variant="contained">
        Details
      </Button>
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
        width={'20vw'}
        height={300}
      />
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={'20vw'}
        height={300}
      />
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={'20vw'}
        height={300}
      />
      <Skeleton
        className={classes.skeletonCard}
        variant="rect"
        width={'20vw'}
        height={300}
      />
    </>
  );
};

export default Products;

const useStyles = makeStyles((theme) => ({
  section: {
    padding: '30px 0',
    '& > h2': {
      marginBottom: '15px',
    },
  },
  cardWrapper: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'space-between',
    gap: '15px',
    flexWrap: 'wrap',
    '@media (max-width:490px)': {
      flexDirection: 'column',
    },
  },
  productCard: {
    display: 'flex',
    width: '24%',
    borderRadius: '10px',
    ...theme.mixins.cardShadow,
    cursor: 'pointer',
    '&:hover': {
      transform: 'scale(1.02)',
    },
    '& .card-img': {
      objectFit: 'cover',
      width: '50%',
      borderRadius: '10px 10px 0px 0px',
    },
    '& .card-text': {
      padding: '10px',
      '& > h3': {
        marginBottom: '5px',
      },
    },
    '@media (max-width:1200px)': {
      width: '45%',
    },
    '@media (max-width:490px)': {
      width: '100%',
    },
  },
  skeletonCard: {
    borderRadius: '10px',
    width: '100%',
  },
}));
