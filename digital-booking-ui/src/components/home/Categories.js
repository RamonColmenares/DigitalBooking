import React, { useEffect } from "react";
import { useCategoriesStore } from "../../stores/categories";

const Categories = () => {
  const categories = useCategoriesStore((s) => s.data);
  const fetchCategories = useCategoriesStore((s) => s.fetchData);

  useEffect(() => {
    fetchCategories();
  }, [fetchCategories]);

  console.log({ categories });
  return (
    <section>
      <h2>Search by Category</h2>
      {}
    </section>
  );
};

const CategoryCard = ({ id, title, description, img }) => {
  return <div>{/* <img src= /> */}</div>;
};

export default Categories;
