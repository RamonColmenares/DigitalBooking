import { url_base } from "./fetchLink";

export const fetchProductsByCity = async (id) => {
  try {
    const response = await fetch(`${url_base}/products/allCity/${id}`);
    const data = await response.json();
    return data;
  } catch (e) {
    console.log(e);
    return [];
  }
};
