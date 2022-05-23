import { apiRequest } from "../client/mocks/categoriesMock";
import { create } from "../utils/createStore";

const createCategoriesStore = () =>
  create("categories")((set, get, api) => ({
    data: [],

    fetchData: async () => {
      const response = await apiRequest();
      set({ data: response });
      return;
    },
  }));

export const useCategoriesStore = createCategoriesStore();
