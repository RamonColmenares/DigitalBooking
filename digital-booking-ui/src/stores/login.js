import { create } from "../utils/createStore";
import { fetchLogin } from "../client/auth/fetchLogin";

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

    fetchLogin: async () => {
      const { email, password } = get();

      const credentials = {
        username: email,
        password,
      };
      let formBody = [];
      for (const property in credentials) {
        const encodedKey = encodeURIComponent(property);
        const encodedValue = encodeURIComponent(credentials[property]);
        formBody.push(encodedKey + "=" + encodedValue);
      }
      formBody = formBody.join("&");

      await fetchLogin(formBody);
    },

    resetState: () =>
      set({ email: "", password: "", error: "", needAuth: false }),
  }));

export const useLoginStore = createLoginStore();
