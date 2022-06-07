import { create } from "../utils/createStore";

const createSearchStore = () =>
  create("search")((set, get) => ({
    location: null,
    date: [],

    setLocation: (location) => set({ location }),
    resetState: () => set({ location: null, date: [] }),
  }));

export const useSearchStore = createSearchStore();
