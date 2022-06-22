export const fetchCategories = async () => {
  try {
    const response = await fetch(
      'http://my-alb-1936629616.us-east-1.elb.amazonaws.com/categories'
    );
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
