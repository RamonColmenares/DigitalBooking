import { create } from "../utils/createStore";

const INITIAL_FROM_STATE = {
  name: "Adriel",
  surname: "Gomez",
  email: "pepe@gmail.com",
};

const createAuthStore = () =>
  create("auth")((set, get) => ({
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
