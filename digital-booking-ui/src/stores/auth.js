import { create } from "../utils/createStore";

const INITIAL_FROM_STATE = {
  name: "",
  surname: "",
  email: "",
};

const createAuthStore = () =>
  create("auth")((set, get, api) => ({
    ...INITIAL_FROM_STATE,
    cart: [],
    favorites: [],

    setName: (name) => set({ name }),
    setSurname: (surname) => set({ surname }),
    setEmail: (email) => set({ email }),

    resetState: () =>
      set({
        ...INITIAL_FROM_STATE,
        cart: [],
        favorites: [],
      }),
  }));

export const useAuthStore = createAuthStore();
