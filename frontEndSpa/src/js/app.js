const mainView = document.querySelector(".container")

const foodSearch = document.getElementById("food-search")
const foodSearchButton = document.getElementById("food-search-button")

const searchTerm = document.querySelector(".search-term")

const filterButtonOne = document.getElementById("filter-button-one")
const filterButtonTwo = document.getElementById("filter-button-two")
const filterButtonThree = document.getElementById("filter-button-three")

const suggestedPairings = document.querySelector(".suggested-pairings")

const foodPairingsUl = document.getElementById("food-pairings")

const foodPairingsLi = document.getElementById("food-pairings-li")
const pairing1 = document.getElementById("pairing-1")
const pairing2 = document.getElementById("pairing-2")
const pairing3 = document.getElementById("pairing-3")
const pairing4 = document.getElementById("pairing-4")
const pairing5 = document.getElementById("pairing-5")


const flavorAffinities = document.querySelector(".flavor-affinities")
const flavorAffinitiesUl = document.getElementById("flavor-affinities")

const flavorAffinitiesLi = document.getElementById("flavor-affinities-li")
const flavor1 = document.getElementById("flavor-1")
const flavor2 = document.getElementById("flavor-2")
const flavor3 = document.getElementById("flavor-3")
const flavor4 = document.getElementById("flavor-4")

// foodSearchButton.addEventListener('click', () => {
//     searchTerm.innerText = foodSearch.value
//     searchTerm.style.display = "inherit"
//     console.log(foodSearch)

//     filterButtonOne.style.display = "initial"
//     filterButtonTwo.style.display = "initial"
//     filterButtonThree.style.display = "initial"

//     suggestedPairings.style.display = "inherit"
//     setTimeout(() => {
//         foodPairingsLi.style.display = "inherit"
//     }, 200)
//     setTimeout(() => {
//         pairing1.style.display = "inherit"
//     }, 400)
//     setTimeout(() => {
//         pairing2.style.display = "inherit"
//     }, 600)
//     setTimeout(() => {
//         pairing3.style.display = "inherit"
//     }, 800)
//     setTimeout(() => {
//         pairing4.style.display = "inherit"
//     }, 1000)
//     setTimeout(() => {
//         pairing5.style.display = "inherit"
//     }, 1200)
//     flavorAffinities.style.display = "inherit"
//     setTimeout(() => {
//         flavorAffinitiesLi.style.display = "inherit"
//     }, 2000)
//     setTimeout(() => {
//         flavor1.style.display = "inherit"
//     }, 2200)
//     setTimeout(() => {
//         flavor2.style.display = "inherit"
//     }, 2400)
//     setTimeout(() => {
//         flavor3.style.display = "inherit"
//     }, 2600)
//     setTimeout(() => {
//         flavor4.style.display = "inherit"
//     }, 2800)
// })

foodSearch.addEventListener('keydown', function(event) {
    if (event.code === 'Enter') {
        searchTerm.innerText = foodSearch.value
        searchTerm.style.display = "inherit"
        console.log(foodSearch)

        filterButtonOne.style.display = "initial"
        filterButtonTwo.style.display = "initial"
        filterButtonThree.style.display = "initial"

        suggestedPairings.style.display = "inherit"
        setTimeout(() => {
            foodPairingsLi.style.display = "inherit"
        }, 200)
        setTimeout(() => {
            pairing1.style.display = "inherit"
        }, 400)
        setTimeout(() => {
            pairing2.style.display = "inherit"
        }, 600)
        setTimeout(() => {
            pairing3.style.display = "inherit"
        }, 800)
        setTimeout(() => {
            pairing4.style.display = "inherit"
        }, 1000)
        setTimeout(() => {
            pairing5.style.display = "inherit"
        }, 1200)
        flavorAffinities.style.display = "inherit"
        setTimeout(() => {
            flavorAffinitiesLi.style.display = "inherit"
        }, 2000)
        setTimeout(() => {
            flavor1.style.display = "inherit"
        }, 2200)
        setTimeout(() => {
            flavor2.style.display = "inherit"
        }, 2400)
        setTimeout(() => {
            flavor3.style.display = "inherit"
        }, 2600)
        setTimeout(() => {
            flavor4.style.display = "inherit"
        }, 2800)
    }
})