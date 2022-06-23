import { getAuthToken } from "../utils/LocalStorage";
import { url_base } from "./fetchLink";

export const fetchReservation = async (booking) => {
  try {
    const response = await fetch(`${url_base}/bookings`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${getAuthToken()}`,
      },
      body: JSON.stringify(booking),
    });
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
