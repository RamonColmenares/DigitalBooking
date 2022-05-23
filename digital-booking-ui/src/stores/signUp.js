import { create } from "../utils/createStore";

const INITIAL_FROM_STATE = {
  name: "",
  surname: "",
  email: "",
  password: "",
  password2: "",
};

const createSignUpStore = () =>
  create("sign-up")((set, get) => ({
    ...INITIAL_FROM_STATE,
    loaded: false,
    loading: false,
    error: null,

    setName: (name) => set({ name }),
    setSurname: (surname) => set({ surname }),
    setEmail: (email) => set({ email }),
    setPassword: (password) => set({ password }),
    setPassword2: (password2) => set({ password2 }),
    setError: (error) => set({ error }),

    resetState: () =>
      set({
        ...INITIAL_FROM_STATE,
        loaded: false,
        loading: false,
        error: null,
      }),
  }));

export const useSignUpStore = createSignUpStore();
