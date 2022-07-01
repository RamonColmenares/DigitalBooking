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
  currentService: "",
  currentImage: "",
  images: [],
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
    setCurrentService: (currentService) => set({ currentService }),
    setServices: () => {
      const serviceSelected = get().currentService;
      const servicesSelected = get().services;
      if (serviceSelected && !servicesSelected.includes(serviceSelected)) {
        set((state) => {
          return {
            ...state,
            services: [...state.services, serviceSelected],
            currentService: "",
          };
        });
      }
      return;
    },
    setCurrentImage: (img) => set({ currentImage: img }),
    addImages: () => {
      const currentImage = get().currentImage;
      const images = get().images;
      if (currentImage && !images.includes(currentImage)) {
        set((state) => {
          return {
            ...state,
            images: [...state.images, currentImage],
            currentImage: "",
          };
        });
      }
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
