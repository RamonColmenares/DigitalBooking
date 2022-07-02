import { create } from "../utils/createStore";
import { getAuthToken, saveAuthToken } from "../utils/LocalStorage";

const INITIAL_FROM_STATE = {
  name: "Adriel",
  surname: "Gomez",
  email: "pepe@gmail.com",
  id: 1,
};

// const INITIAL_FROM_STATE = {
//   name: "",
//   surname: "",
//   email: "",
//   id: null,
// };

const createAuthStore = () =>
  create("auth")((set, get) => ({
    ...INITIAL_FROM_STATE,
    cart: [],
    favorites: [],

    setName: (name) => set({ name }),
    setSurname: (surname) => set({ surname }),
    setEmail: (email) => set({ email }),
    setId: (id) => set({ id }),

    getValues: () => ({
      name: get().name,
      surname: get().surname,
      email: get().email,
    }),

    saveToken: (token) => saveAuthToken(token),

    getToken: () => getAuthToken(),

    resetState: () =>
      set({
        ...INITIAL_FROM_STATE,
        cart: [],
        favorites: [],
      }),
  }));

export const useAuthStore = createAuthStore();
