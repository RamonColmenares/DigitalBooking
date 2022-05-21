import React from "react";
import { Route, Routes } from "react-router-dom";
import { PrivateRoute } from "./components/routes/PrivateRoute";
import LoginPage from "./pages/login/LoginPage";
import SignUpPage from "./pages/signUp/SignUpPage";
import HomePage from "./pages/home/HomePage";
import NavBar from "./pages/NavBar";
import Footer from "./pages/Footer";

const App = () => {
  return (
    <>
      <NavBar />
      <Routes>
        <Route
          path="/"
          element={
            <PrivateRoute user="true">
              <HomePage />
            </PrivateRoute>
          }
        />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignUpPage />} />
      </Routes>
      <Footer />
    </>
  );
};

export default App;
