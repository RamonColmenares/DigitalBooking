export const fetchSignUp = async (credentials) => {
  try {
    const response = await fetch(
      "http://my-alb-1936629616.us-east-1.elb.amazonaws.com/api/user/save",
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(credentials),
      }
    );
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
