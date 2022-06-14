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
    loading: false,
    loaded: false,
    error: "",

    setName: (name) => set({ name }),
    setSurname: (surname) => set({ surname }),
    setEmail: (email) => set({ email }),
    setCity: (city) => set({ city }),
    setArrivalTime: (arrivalTime) => set({ arrivalTime }),

    setDateRange: (dateRange) => set({ dateRange }),

    setError: (error) => set({ error }),
    setloading: (loading) => set({ loading }),
    setLoaded: (loaded) => set({ loaded }),

    setDefaultValues: ({ name, surname, email }) =>
      set({ name, surname, email }),

    getErrorDates: () => {
      const [startDate, endDate] = get().dateRange;

      return !startDate || !endDate;
    },

    getFormValues: () => {
      return {
        name: get().name,
        surname: get().surname,
        email: get().email,
        city: get().city,
        startDate: get().dateRange[0],
        endDate: get().dateRange[1],
        arrivalTime: get().arrivalTime,
      };
    },
  }));

export const useReservationStore = createReservationSotre();
