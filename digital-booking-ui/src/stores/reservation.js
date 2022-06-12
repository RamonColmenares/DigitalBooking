import { create } from "../utils/createStore";

const INITIAL_STATE = {
  name: "",
  surname: "",
  email: "",
  city: "",
  startDate: "",
  endDate: "",
  arriveTime: "",
};

const createReservationSotre = () =>
  create("reservation")((set, get) => ({
    ...INITIAL_STATE,
    setName: (name) => set({ name }),
    setSurname: (surname) => set({ surname }),
    setEmail: (email) => set({ email }),
    setCity: (city) => set({ city }),
    setArriveTime: (arriveTime) => set({ arriveTime }),
  }));

export const useReservationStore = createReservationSotre();
