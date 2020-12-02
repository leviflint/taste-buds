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
const flipcardContainer = document.getElementById("flipcard-container")
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


  // Card One

  const flipcard1 = document.createElement("div");
  flipcard1.classList.add("flipCard");
  flipcardContainer.appendChild(flipcard1)

  const card1 = document.createElement("div");
  card1.classList.add("card");
  card1.onclick = function () {
    this.classList.toggle('flipped')
  }
  flipcard1.appendChild(card1)

  const cardFront1 = document.createElement("div");
  cardFront1.classList.add("side")
  cardFront1.classList.add("front")
  cardFront1.innerText = ingredient.affinity1;
  card1.appendChild(cardFront1)

  const cardBack1 = document.createElement("div")
  cardBack1.classList.add("side")
  cardBack1.classList.add("back")
  card1.appendChild(cardBack1)

  const cardRecipe1 = document.createElement("a")
  cardRecipe1.target = ("_blank")
  cardRecipe1.rel = ("noopener noreferrer")
  cardRecipe1.href = ingredient.affinity1Url
  cardBack1.appendChild(cardRecipe1)

  const recipeImage1 = document.createElement("img")
  recipeImage1.src = ingredient.affinity1Photo
  recipeImage1.id = ("affinity-1-img")
  cardRecipe1.appendChild(recipeImage1)
  
  const overlay1 = document.createElement("div")
  overlay1.classList.add("overlay")
  cardRecipe1.appendChild(overlay1)

  const overlayText1 = document.createElement("div")
  overlayText1.classList.add("text")
  overlayText1.innerText = "Click for Recipe"
  overlay1.appendChild(overlayText1)


  // Card Two
  
  const flipcard2 = document.createElement("div");
  flipcard2.classList.add("flipCard");
  flipcardContainer.appendChild(flipcard2)

  const card2 = document.createElement("div");
  card2.classList.add("card");
  card2.onclick = function () {
    this.classList.toggle('flipped')
  }
  flipcard2.appendChild(card2)

  const cardFront2 = document.createElement("div");
  cardFront2.classList.add("side")
  cardFront2.classList.add("front")
  cardFront2.innerText = ingredient.affinity2
  card2.appendChild(cardFront2)

  const cardBack2 = document.createElement("div")
  cardBack2.classList.add("side")
  cardBack2.classList.add("back")
  card2.appendChild(cardBack2)

  const cardRecipe2 = document.createElement("a")
  cardRecipe2.target = ("_blank")
  cardRecipe2.rel = ("noopener noreferrer")
  cardRecipe2.href = ingredient.affinity2Url
  cardBack2.appendChild(cardRecipe2)

  const recipeImage2 = document.createElement("img")
  recipeImage2.src = ingredient.affinity2Photo
  recipeImage2.id = ("affinity-2-img")
  cardRecipe2.appendChild(recipeImage2)

  const overlay2 = document.createElement("div")
  overlay2.classList.add("overlay")
  cardRecipe2.appendChild(overlay2)

  const overlayText2 = document.createElement("div")
  overlayText2.classList.add("text")
  overlayText2.innerText = "Click for Recipe"
  overlay2.appendChild(overlayText2)
  //Card Three

  const flipcard3 = document.createElement("div");
  flipcard3.classList.add("flipCard");
  flipcardContainer.appendChild(flipcard3)

  const card3 = document.createElement("div");
  card3.classList.add("card");
  card3.onclick = function () {
    this.classList.toggle('flipped')
  }
  flipcard3.appendChild(card3)

  const cardFront3 = document.createElement("div");
  cardFront3.classList.add("side")
  cardFront3.classList.add("front")
  cardFront3.id = ("affinity-3")
  cardFront3.innerText = ingredient.affinity3
  card3.appendChild(cardFront3)

  const cardBack3 = document.createElement("div")
  cardBack3.classList.add("side")
  cardBack3.classList.add("back")
  card3.appendChild(cardBack3)

  const cardRecipe3 = document.createElement("a")
  cardRecipe3.target = ("_blank")
  cardRecipe3.rel = ("noopener noreferrer")
  cardRecipe3.href = ingredient.affinity3Url
  cardBack3.appendChild(cardRecipe3)

  const recipeImage3 = document.createElement("img")
  recipeImage3.src = ingredient.affinity3Photo
  recipeImage3.id = ("affinity-3-img")
  cardRecipe3.appendChild(recipeImage3)

  const overlay3 = document.createElement("div")
  overlay3.classList.add("overlay")
  cardRecipe3.appendChild(overlay3)

  const overlayText3 = document.createElement("div")
  overlayText3.classList.add("text")
  overlayText3.innerText = "Click for Recipe"
  overlay3.appendChild(overlayText3)

  setTimeout(() => {
    flavorAffinities.style.visibility = "visible";
  }, 1400);
}



foodSearch.addEventListener("keydown", function (event) {
  if (event.code === "Enter") {
    searchTerm.innerText = foodSearch.value;
    searchTerm.style.display = "inherit";
    clearChildren(foodPairingsUl)
    clearChildren(flipcardContainer)
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




    
    foodSearch.value = "";
  }
});

const clearChildren = function (element) {
  while (element.firstChild) {
    element.removeChild(element.lastChild);
  }
}

