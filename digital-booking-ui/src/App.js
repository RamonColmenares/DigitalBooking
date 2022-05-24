import React from "react";
import { Route, Routes } from "react-router-dom";
import LoginPage from "./pages/login/LoginPage";
import SignUpPage from "./pages/signUp/SignUpPage";
import HomePage from "./pages/home/HomePage";
import NavBar from "./pages/NavBar";
import Footer from "./pages/Footer";
import { PubliceRoute } from "./components/routes/PublicRoute";
import { useAuthStore } from "./stores/auth";

const App = () => {
  const user = useAuthStore((s) => s.name);

  return (
    <>
      <NavBar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route
          path="/login"
          element={
            <PubliceRoute user={user}>
              <LoginPage />
            </PubliceRoute>
          }
        />
        <Route
          path="/signup"
          element={
            <PubliceRoute user={user}>
              <SignUpPage />
            </PubliceRoute>
          }
        />
      </Routes>
      <Footer />
    </>
  );
};

export default App;
