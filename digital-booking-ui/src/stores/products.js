import { apiRequest } from "../client/mocks/acommodationList";
import { create } from "../utils/createStore";

const createProductsStore = () =>
  create("products")((set, get) => ({
    data: [],
    dataBackUp: [],
    loading: false,
    loaded: false,
    filterCategory: "",

    fetchData: async () => {
      set((state) => ({ ...state, loading: true }));
      const response = await apiRequest();
      set({
        data: response,
        dataBackUp: response,
        loaded: true,
        loading: false,
      });
      return;
    },
    setFilter: (category) => {
      const filteredData = get().dataBackUp.filter(
        (accomodation) => accomodation.category === category
      );
      set({ data: filteredData, filterCategory: category });
    },
    clearFilter: () =>
      set((state) => ({
        ...state,
        data: state.dataBackUp,
        filterCategory: "",
      })),
  }));

export const useProductsStore = createProductsStore();
