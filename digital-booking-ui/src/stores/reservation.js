import { create } from "../utils/createStore";

const INITIAL_STATE = {
  name: "",
  surname: "",
  email: "",
  city: "",
  dateRange: [null, null],
  arrivalTime: "07:30",
};

const createReservationSotre = () =>
  create("reservation")((set, get) => ({
    ...INITIAL_STATE,

    setName: (name) => set({ name }),
    setSurname: (surname) => set({ surname }),
    setEmail: (email) => set({ email }),
    setCity: (city) => set({ city }),
    setArrivalTime: (arrivalTime) => set({ arrivalTime }),

    setDateRange: (dateRange) => set({ dateRange }),

    setDefaultValues: ({ name, surname, email }) =>
      set({ name, surname, email }),
  }));

export const useReservationStore = createReservationSotre();
