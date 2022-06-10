export const fetchProducts = async () => {
  try {
    const response = await fetch('http://localhost:8081/products');
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
