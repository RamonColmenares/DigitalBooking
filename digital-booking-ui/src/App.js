import React from "react";
import { Route, Routes } from "react-router-dom";
import AppContent from "./components/AppContent";
import Login from "./components/auth/Login";
import SignUp from "./components/auth/SignUp";
import { PrivateRoute } from "./components/routes/PrivateRoute";

const App = () => {
  return (
    <div>
      <Routes>
        <Route
          path="/"
          element={
            <PrivateRoute user="true">
              <AppContent />
            </PrivateRoute>
          }
        />
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
      </Routes>
    </div>
  );
};

export default App;
