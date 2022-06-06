import { fetchProducts } from "../client/fetchProducts";
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
      const response = await fetchProducts();
      set({
        data: response,
        dataBackUp: response,
        loaded: true,
        loading: false,
      });
      return;
    },
    filterByCategory: (category) => {
      const filteredData = get().dataBackUp.filter(
        (accomodation) => accomodation.category.title === category
      );
      set({ data: filteredData, filterCategory: category });
    },
    filterByLocation: (location) => {
      const filteredData = get().dataBackUp.filter(
        (accomodation) => accomodation.city.name === location.name
      );
      set({ data: filteredData });
    },
    clearFilter: () =>
      set((state) => ({
        ...state,
        data: state.dataBackUp,
        filterCategory: "",
      })),
  }));

export const useProductsStore = createProductsStore();
