export const saveAuthToken = (token) => {
  localStorage.setItem("token", token);
  return;
};

export const getAuthToken = () => {
  return localStorage.getItem("token");
};
