export const fetchCities = async () => {
  try {
    const response = await fetch("http://localhost:8081/cities");
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
