import { create } from "../utils/createStore";
import { fetchLogin } from "../client/auth/fetchLogin";
import { saveAuthToken } from "../utils/LocalStorage";

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
      const response = await fetchLogin(credentials);
      if (response?.access_token) {
        const { access_token, name, lastName } = response;
        saveAuthToken(access_token);
        return { name, lastName };
      } else {
        set({ error: "An error ocurred while trying to log in" });
      }
      return;
    },

    resetState: () =>
      set({ email: "", password: "", error: "", needAuth: false }),
  }));

export const useLoginStore = createLoginStore();
