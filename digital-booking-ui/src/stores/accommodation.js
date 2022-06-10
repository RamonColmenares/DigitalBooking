import { fetchAccommodation } from "../client/fetchAccommodation";
import { create } from "../utils/createStore";

const createAccommodationStore = () =>
  create("accommodation")((set, get) => ({
    data: [],
    loading: false,
    loaded: false,
    error: false,

    fetchData: async (id) => {
      try {
        set((state) => ({ ...state, loading: true }));
        const response = await fetchAccommodation(id);
        console.log({ response });
        set({ data: response, loaded: true, loading: false });
        return;
      } catch (e) {
        set({ error: true, data: [], loaded: true, loading: false });
        return;
      }
    },
  }));

export const useAccommodationStore = createAccommodationStore();
