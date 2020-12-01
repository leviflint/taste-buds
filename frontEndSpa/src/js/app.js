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



const displayPairings = function (ingredient) {
  let timerValue = 200

  ingredient.pairings.forEach((pairings) => {
    const pairingList = document.createElement("li");
    if (pairings.textStyle == 1) {
      pairingList.style.fontWeight = "900"
    } 
    if (pairings.textStyle == 3) {
      pairingList.style.fontStyle = "italic"
    } 
    pairingList.innerText = pairings.name;
    setTimeout(() => {
      foodPairingsUl.append(pairingList)
      pairingList.style.display = "inherit";
    }, timerValue)
    timerValue += 200
  })
};

const displayAffinities = function (ingredient) {
  let timerValue = 800
  const affinity1 = document.getElementById("affinity-1")
  const affinity1Url = document.getElementById("affinity-1-url")
  const affinity1Img = document.getElementById("affinity-1-img")
  const affinity2 = document.getElementById("affinity-2")
  const affinity2Url = document.getElementById("affinity-2-url")
  const affinity2Img = document.getElementById("affinity-2-img")
  const affinity3 = document.getElementById("affinity-3")
  const affinity3Url = document.getElementById("affinity-3-url")
  const affinity3Img = document.getElementById("affinity-3-img")
  affinity1.innerText = ingredient.affinity1;
  affinity1Url.href = ingredient.affinity1Url;
  affinity1Img.src = ingredient.affinity1Photo;
  affinity2.innerText = ingredient.affinity2;
  affinity2Url.href = ingredient.affinity2Url;
  affinity2Img.src = ingredient.affinity2Photo;
  affinity3.innerText = ingredient.affinity3;
  affinity3Url.href = ingredient.affinity3Url;
  affinity3Img.src = ingredient.affinity3Photo;
  // setTimeout(() => {
  //   flavorAffinitiesUl.append(flavor1)
  //   flavor1.style.display = "inherit";
  // }, 1000);
  // setTimeout(() => {
  //   flavorAffinitiesUl.append(flavor2)
  //   flavor2.style.display = "inherit";
  // }, 1200);
  // setTimeout(() => {
  //   flavorAffinitiesUl.append(flavor3)
  //   flavor3.style.display = "inherit";
  // }, 1400);
}



foodSearch.addEventListener("keydown", function (event) {
  if (event.code === "Enter") {
    searchTerm.innerText = foodSearch.value;
    searchTerm.style.display = "inherit";
    clearChildren(foodPairingsUl)
    // clearChildren(flavorAffinitiesUl)
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
      .catch((error) => console.log(error));

    fetch(`http://localhost:8080/api/ingredient-name/${foodSearch.value}`, {
      method: "GET",
      mode: "cors",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((ingredient) => displayAffinities(ingredient))
      .catch((error) => console.log(error));




    flavorAffinities.style.display = "inherit";

  }
});

const clearChildren = function (element) {
  while (element.firstChild) {
    element.removeChild(element.lastChild);
  }
}

