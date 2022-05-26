import { apiRequest } from '../client/mocks/acommodationList';
import { create } from '../utils/createStore';

const createProductsStore = () =>
  create('products')((set, get) => ({
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

export const useProductsStore = createProductsStore();
