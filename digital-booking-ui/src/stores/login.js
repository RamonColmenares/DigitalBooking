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
      const { access_token, refresh_token } = await fetchLogin(credentials);
      console.log(access_token);
      saveAuthToken(access_token);
      return;
    },

    resetState: () =>
      set({ email: "", password: "", error: "", needAuth: false }),
  }));

export const useLoginStore = createLoginStore();
