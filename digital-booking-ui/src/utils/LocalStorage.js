export const saveAuthToken = (token) => {
  localStorage.setItem(token, "token");
  return;
};

export const getAuthToken = () => {
  return JSON.stringify(localStorage.getItem("token"));
};
