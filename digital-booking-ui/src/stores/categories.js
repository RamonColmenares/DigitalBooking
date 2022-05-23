import { apiRequest } from "../client/mocks/categoriesMock";
import { create } from "../utils/createStore";

const createCategoriesStore = () =>
  create("categories")((set, get) => ({
    data: [],
    loading: false,
    loaded: false,

    fetchData: async () => {
      set((state) => ({ ...state, loading: true }));
      const response = await apiRequest();
      set({ data: response, loaded: true, loading: false });
      return;
    },
  }));

export const useCategoriesStore = createCategoriesStore();
