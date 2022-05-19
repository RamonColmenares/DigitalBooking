import { createTheme } from "@material-ui/core/styles";

export default createTheme({
  typography: {
    fontFamily: '"PT Sans", Roboto, Helvetica, sans-serif',
  },
  palette: {
    white: "rgb(255,255,255)",
    secondary: {
      light: "rgb(221,226,198)",
      dark: "rgb(0,4,17)",
      main: "rgb(63,55,55)",
    },
    primary: {
      main: "rgb(29, 190, 180)",

      secondary: "rgb(156,63,1)",
      light: "rgb(47, 82, 20)",
    },
    text: {
      primary: "rgba(56, 59, 88, 1)",
      dark: "rgb(0,4,17)",
      hint: "rgb(192,187,187)",
    },
  },

  success: "rgb(89,157,38)",
  warning: "rgb(255,160,0)",
  error: "rgb(156,63,1)",

  mixins: {
    entityPill: {
      padding: "0px 8px",
      fontSize: "12px",
      height: "20px",
      lineHeight: "16px",
      fontWeight: "bold",
      color: "var(--entity-color)",
      backgroundColor: "var(--entity-background, transparent)",
      border: `2px solid var(--entity-background, var(--entity-color))`,
      boxSizing: "border-box",
    },
    textOverflow: {
      overflow: "hidden",
      textOverflow: "ellipsis",
      whiteSpace: "nowrap",
    },
    textClamp: (lines) => ({
      display: "-webkit-box",
      "-webkit-line-clamp": lines,
      "-webkit-box-orient": "vertical",
      overflow: "hidden",
    }),
    noScroll: {
      "-webkit-overflow-scrolling": "touch",
      "-ms-overflow-style": "none",
      "&::-webkit-scrollbar": {
        display: "none",
        width: "0 !important",
      },
    },
    pocketShadow: {
      background: `linear-gradient(rgb(255,255,255) 30%, rgba(255,255,255,0)), linear-gradient(rgba(255,255,255,0), rgb(255,255,255) 70%) 0 100%, radial-gradient(farthest-side at 50% 0, rgba(0,0,0,.1), rgba(0,0,0,0)), radial-gradient(farthest-side at 50% 100%, rgba(0,0,0,.1), rgba(0,0,0,0)) 0 100%`,
      backgroundRepeat: "no-repeat",
      backgroundSize: "100% 40px, 100% 40px, 100% 10px, 100% 10px",
      backgroundAttachment: "local, local, scroll, scroll",
    },
  },
});
