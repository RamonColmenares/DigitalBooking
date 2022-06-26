import { create } from "../utils/createStore";

const INITIAL_STATE = {
  name: "",
  category: "",
  city: "",
  address: "",
  description: "",
  latitude: "",
  longitude: "",
};

const createAdminStore = () =>
  create("admin")((set, get) => ({
    ...INITIAL_STATE,
    loading: false,
    loaded: false,
    error: false,

    setName: (name) => set({ name }),
    setCategory: (category) => set({ category }),
    setAddress: (address) => set({ address }),
    setDescription: (description) => set({ description }),
    setLatitude: (latitude) => set({ latitude }),
    setLongitude: (longitude) => set({ longitude }),
    setCity: (city) => {
      set({
        city,
        //This format when do the post
        // city: {
        //   name: "Buenos Aires",
        //   name_country: "Argentina",
        // },
      });
    },
  }));

export const useAdminStore = createAdminStore();
