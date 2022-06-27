import { create } from "../utils/createStore";

const INITIAL_STATE = {
  name: "",
  category: "",
  city: "",
  address: "",
  description: "",
  latitude: "",
  longitude: "",
  services: [],
  service: "",
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
      });
    },
    setService: (service) => set({ service }),
    setServices: () => {
      const serviceSelected = get().service;
      const servicesSelected = get().services;
      if (serviceSelected && !servicesSelected.includes(serviceSelected)) {
        set((state) => {
          return {
            ...state,
            services: [...state.services, serviceSelected],
            service: "",
          };
        });
      }
      return;
    },
    deleteService: (serviceToRemove) =>
      set((state) => ({
        ...state,
        services: state.services.filter(
          (service) => service !== serviceToRemove
        ),
      })),
  }));

export const useAdminStore = createAdminStore();
