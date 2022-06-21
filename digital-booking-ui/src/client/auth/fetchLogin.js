export const fetchLogin = async (credentials) => {
  try {
    const response = await fetch("http://localhost:8081/api/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
      },
      body: credentials,
    });
    const data = await response.json();
    console.log({ data });
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
