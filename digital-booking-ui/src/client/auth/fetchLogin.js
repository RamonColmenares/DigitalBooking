export const fetchLogin = async (credentials) => {
  try {
    const response = await fetch("http://localhost:8081/api/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
      },
      body: new URLSearchParams(credentials),
    });
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
