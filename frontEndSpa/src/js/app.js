import { allIngredients } from "./sampleIngredientJSON.js";

const mainView = document.querySelector(".container");

const foodSearch = document.getElementById("food-search");
const foodSearchValue = document.getElementById("food-search").value;

const searchTerm = document.querySelector(".search-term");

const filterButtonOne = document.getElementById("filter-button-one");
const filterButtonTwo = document.getElementById("filter-button-two");
const filterButtonThree = document.getElementById("filter-button-three");

const suggestedPairings = document.querySelector(".suggested-pairings");

const foodPairingsUl = document.getElementById("food-pairings");
const foodPairingsLi = document.getElementById("food-pairings-li");

const pairing1 = document.getElementById("pairing-1");
const pairing2 = document.getElementById("pairing-2");
const pairing3 = document.getElementById("pairing-3");
const pairing4 = document.getElementById("pairing-4");
const pairing5 = document.getElementById("pairing-5");

const flavorAffinities = document.querySelector(".flavor-affinities");
const flavorAffinitiesUl = document.getElementById("flavor-affinities");

const flavorAffinitiesLi = document.getElementById("flavor-affinities-li");
const flavor1 = document.getElementById("flavor-1");
const flavor2 = document.getElementById("flavor-2");
const flavor3 = document.getElementById("flavor-3");
const flavor4 = document.getElementById("flavor-4");

const displayPairings = function (ingredient) {
  let timerValue = 200
  ingredient.pairings.forEach((pairings) => {
    const pairingList = document.createElement("li");
    pairingList.id = `pairing-${pairings.id}`;
    pairingList.innerText = pairings.name;
    console.log(pairingList)
    setTimeout(() => {
      foodPairingsUl.append(pairingList)
      pairingList.style.display = "inherit";
    }, timerValue)
    timerValue += 200
  })
};

const displayAffinities = function (ingredient) {
  let timerValue = 200
  ingredient.affinities.forEach((affinities) => {
    flavor1.innerText = affinities.affinity1;
    flavor2.innerText = affinities.affinity2;
    flavor3.innerText = affinities.affinity3;
  })

}



foodSearch.addEventListener("keydown", function (event) {
  if (event.code === "Enter") {
    searchTerm.innerText = foodSearch.value;
    searchTerm.style.display = "inherit";

    filterButtonOne.style.display = "initial";
    filterButtonTwo.style.display = "initial";
    filterButtonThree.style.display = "initial";
    suggestedPairings.style.display = "inherit";
    fetch(`http://localhost:8080/api/ingredient-name/${foodSearch.value}`, {
      method: "GET",
      mode: "cors",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((ingredient) => displayPairings(ingredient))
      .then((ingredient) => displayAffinities(ingredient))
      .catch((error) => console.log(error));
    // foodPairingsUl.append(displayPairings(allIngredients));
    // setTimeout(() => {
    //   foodPairingsLi.style.display = "inherit";
    // }, 200);
    // setTimeout(() => {
    //   pairing1.style.display = "inherit";
    // }, 400);
    // setTimeout(() => {
    //   pairing2.style.display = "inherit";
    // }, 600);
    // setTimeout(() => {
    //   pairing3.style.display = "inherit";
    // }, 800);
    // setTimeout(() => {
    //   pairing4.style.display = "inherit";
    // }, 1000);
    // setTimeout(() => {
    //   pairing5.style.display = "inherit";
    // }, 1200);
    // flavorAffinities.style.display = "inherit";
    // setTimeout(() => {
    //   flavorAffinitiesLi.style.display = "inherit";
    // }, 2000);
    setTimeout(() => {
      flavor1.style.display = "inherit";
    }, 2200);
    setTimeout(() => {
      flavor2.style.display = "inherit";
    }, 2400);
    setTimeout(() => {
      flavor3.style.display = "inherit";
    }, 2600);
    // setTimeout(() => {
    //   flavor4.style.display = "inherit";
    // }, 2800);
  }
});

