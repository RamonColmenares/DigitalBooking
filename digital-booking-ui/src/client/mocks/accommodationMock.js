import { delay } from "../../utils/delay";

const data = [
  {
    id: 1,
    crimg:
      "https://images.unsplash.com/photo-1618773928121-c32242e63f39?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170",
    category: "Hotels",
    title: "Freehand Toronto - Premium King Room",
    location: "Toronto, Canada",
    description:
      "Designed by famed duo Roman & Williams, with custom art by Bard College students and alumni throughout.",
  },
];

export const apiRequest = async () => {
  await delay(1000);

  return data;
};
