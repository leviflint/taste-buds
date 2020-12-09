const body = document.getElementById("body");
const header = document.querySelector(".header");
const search = document.querySelector(".search");
const autoComplete = document.querySelector(".autocomplete-items")
const foodSearch = document.querySelector(".food-search");
const suggestedPairings = document.querySelector(".suggested-pairings");
const flavorAffinities = document.querySelector(".flavor-affinities");
const modalContent = document.querySelector(".modal-content");
const closeModalButton = document.querySelector(".close");
const slider = document.getElementById("slider");

const sliderBlog = document.getElementById("slider-blog");
const inspirationWall = document.getElementById("search")



slider.addEventListener("change", () => {
    body.classList.toggle("body-darkMode")
    header.classList.toggle("header-darkmode")
    search.classList.toggle("search-darkMode")
        // autoComplete.classList.toggle("autocomplete-darkmode")
    foodSearch.classList.toggle("food-search-darkMode")
    suggestedPairings.classList.toggle("suggested-pairings-darkMode")
    flavorAffinities.classList.toggle("flavor-affinities-darkMode")
        // modalContent.classList.toggle("modal-content-darkMode")
    closeModalButton.classList.toggle("close-darkMode")
})

sliderBlog.addEventListener("change", () => {
    body.classList.toggle("body-darkMode")
    header.classList.toggle("header-darkmode")
    inspirationWall.classList.toggle("inspiration-wall-darkmode")
})