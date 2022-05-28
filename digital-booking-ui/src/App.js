import React, { useEffect } from "react";
import { Route, Routes } from "react-router-dom";
import LoginPage from "./pages/login/LoginPage";
import SignUpPage from "./pages/signUp/SignUpPage";
import HomePage from "./pages/home/HomePage";
import NavBar from "./pages/NavBar";
import Footer from "./pages/Footer";
import { PubliceRoute } from "./components/routes/PublicRoute";
import { useAuthStore } from "./stores/auth";
import { useCitiesStore } from "./stores/cities";
import AccommodationPage from "./pages/accommodation/AccommodationPage";
import { makeStyles } from "@material-ui/core";

const App = () => {
  const user = useAuthStore((s) => s.name);
  const classes = useStyles();

  const cities = useCitiesStore((s) => s.data);
  const fetchCities = useCitiesStore((s) => s.fetchData);

  useEffect(() => {
    fetchCities();
  }, []);

  console.log({ cities });

  return (
    <>
      <NavBar />
      <main className={classes.main}>
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
          <Route path="accommodation/:id" element={<AccommodationPage />} />
        </Routes>
      </main>
      <Footer />
    </>
  );
};

export default App;

const useStyles = makeStyles(() => ({
  main: {
    minHeight: "85vh",
  },
}));
