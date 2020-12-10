import { createDarkAutofill } from "./autoComplete.js"

const body = document.getElementById("body");
const header = document.querySelector(".header");
const search = document.querySelector(".search");
const foodSearch = document.querySelector(".food-search");
const suggestedPairings = document.querySelector(".suggested-pairings");
const flavorAffinities = document.querySelector(".flavor-affinities");
const slider = document.getElementById("slider");

const sliderBlog = document.getElementById("slider-blog");
const inspirationWall = document.getElementById("search")



slider.addEventListener("change", () => {
    body.classList.toggle("body-darkMode")
    header.classList.toggle("light-text")
    search.classList.toggle("dark-background")
    foodSearch.classList.toggle("complete-switch")
    suggestedPairings.classList.toggle("dark-background")
    flavorAffinities.classList.toggle("dark-background")
    createDarkAutofill();
})

sliderBlog.addEventListener("change", () => {
    body.classList.toggle("body-darkMode")
    header.classList.toggle("header-darkmode")
    inspirationWall.classList.toggle("inspiration-wall-darkmode")
})