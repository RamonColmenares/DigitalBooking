import React from "react";
import { Navigate } from "react-router-dom";

export const PrivateRoute = ({ children, user }) => {
  // Add your own authentication on the below line.
  return user ? children : <Navigate to="/login" />;
};
