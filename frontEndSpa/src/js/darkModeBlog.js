const body = document.getElementById("body");
const header = document.querySelector(".header");
const dropdownLinks = document.querySelector(".dropdown-content");
const sliderBlog = document.getElementById("slider-blog");
const inspirationWall = document.getElementById("search")
const dropdown = document.getElementById('dropdown');
const hashtag = document.getElementById('hashtag')
const recipe = document.getElementById('recipe-name')
const link = document.getElementById('link')
const photo = document.getElementById('photo')

sliderBlog.addEventListener("change", () => {
    body.classList.toggle("body-darkMode")
    header.classList.toggle("light-text")
    dropdownLinks.classList.toggle("dropdown-content-dark")
    inspirationWall.classList.toggle("inspiration-wall-darkmode")
    dropdown.classList.toggle('dark-background')
    hashtag.classList.toggle('input')
    recipe.classList.toggle('input')
    link.classList.toggle('input')
    photo.classList.toggle('input')
})