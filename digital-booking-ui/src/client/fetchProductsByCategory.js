export const fetchProductsByCategory = async (id) => {
  try {
    const response = await fetch(
      `http://localhost:8081/products/allCategory/${id}`
    );
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
