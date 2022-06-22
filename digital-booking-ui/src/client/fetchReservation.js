import { getAuthToken } from "../utils/LocalStorage";

export const fetchReservation = async (booking) => {
  try {
    const response = await fetch(
      "http://my-alb-1936629616.us-east-1.elb.amazonaws.com/bookings",
      {
        method: "POST",
        credentials: "include",
        headers: {
          "Content-Type": "application/json",
          Authorization: getAuthToken(),
        },
        body: JSON.stringify(booking),
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
