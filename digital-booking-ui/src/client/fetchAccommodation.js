export const fetchAccommodation = async (id) => {
  try {
    const response = await fetch(`http://localhost:8081/products/${id}`);
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
