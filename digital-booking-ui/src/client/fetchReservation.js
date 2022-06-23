import { getAuthToken } from "../utils/LocalStorage";
import { url_base } from "./fetchLink";

export const fetchReservation = async (booking) => {
  console.log(JSON.stringify(booking));
  console.log(getAuthToken);
  try {
    const response = await fetch(
      `${url_base}/bookings`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          "Authorization": "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYW1vbkBsbWFpbC5jb20iLCJyb2xlcyI6WyJBRE1JTiJdLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODEvYXBpL2xvZ2luIiwiZXhwIjoxNjU1OTUwMDQxfQ.XK1VXxDhA_Q7T_gvlxndJpt3vYRFIKaPed6gI6JOfEg"
          },
        body: JSON.stringify(booking)
      }
    );
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};

// booking: {
//     "startDate":"2022-06-10",
//     "endDate":"2022-06-14",
//     "hour":"00:00:00",
//     "vaccinated":true,
//     "productId":1,
//     "userId":1
// }
