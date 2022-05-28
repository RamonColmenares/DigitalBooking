import { apiRequest } from "../client/mocks/accommodationMock";
import { create } from "../utils/createStore";

const createAccommodationStore = () =>
  create("accommodation")((set, get) => ({
    data: [],
    loading: false,
    loaded: false,
    error: false,

    fetchData: async () => {
      try {
        set((state) => ({ ...state, loading: true }));
        const response = await apiRequest();
        const [data] = response;
        set({ data, loaded: true, loading: false });
        return;
      } catch (e) {
        set({ error: true, data: [], loaded: true, loading: false });
        return;
      }
    },
  }));

export const useAccommodationStore = createAccommodationStore();
