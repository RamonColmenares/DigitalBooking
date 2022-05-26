// https://countriesnow.space/api/v0.1/countries/population/cities

import { create } from "../utils/createStore";

const createCitiesStore = () =>
  create("cities")((set, get) => ({
    data: [],
    loading: false,
    loaded: false,
    error: false,

    fetchData: async () => {
      set((state) => ({ ...state, loading: true }));
      try {
        const response = await fetch(
          "https://countriesnow.space/api/v0.1/countries/population/cities"
        );
        const data = await response.json();

        set({ data: data, loaded: true, loading: false });
      } catch (e) {
        console.log("Error while fetching cities: ", e);
        set({
          data: [],
          loaded: true,
          loading: false,
          error: "Error while fetching Cities",
        });
      }
    },
  }));

export const useCitiesStore = createCitiesStore();
