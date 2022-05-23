import { create } from "../utils/createStore";

const createLoginStore = () =>
  create("login")((set, get) => ({
    email: "",
    password: "",
    error: "",

    setEmail: (email) => set({ email }),
    setPassword: (password) => set({ password }),
    setError: (error) => set({ error }),

    resetState: () => set({ email: "", password: "" }),
  }));

export const useLoginStore = createLoginStore();
