import { create } from "../utils/createStore";

const createLoginStore = () =>
  create("login")((set, get) => ({
    email: "",
    password: "",
    error: "",
    needAuth: false,

    setEmail: (email) => set({ email }),
    setPassword: (password) => set({ password }),
    setError: (error) => set({ error }),
    setNeedAuth: () => set({ needAuth: true }),

    resetState: () =>
      set({ email: "", password: "", error: "", needAuth: false }),
  }));

export const useLoginStore = createLoginStore();
