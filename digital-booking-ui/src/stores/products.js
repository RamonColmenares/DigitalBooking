import { fetchProducts } from "../client/fetchProducts";
import { fetchProductsByCategory } from "../client/fetchProductsByCategory";
import { apiRequest } from "../client/mocks/acommodationList";
import { create } from "../utils/createStore";

const createProductsStore = () =>
  create("products")((set, get) => ({
    data: [],
    dataBackUp: [],
    loading: false,
    loaded: false,

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
    fetchDataByCategory: async (id) => {
      set((state) => ({ ...state, loading: true }));
      const response = await fetchProductsByCategory(id);
      set({
        data: response,
        loaded: true,
        loading: false,
      });
      return;
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
      })),
  }));

export const useProductsStore = createProductsStore();
