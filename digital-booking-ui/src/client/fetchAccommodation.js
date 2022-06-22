export const fetchAccommodation = async (id) => {
  try {
    const response = await fetch(
      `http://my-alb-1936629616.us-east-1.elb.amazonaws.com/products/${id}`
    );
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
