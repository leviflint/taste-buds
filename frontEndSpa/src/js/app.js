const foodSearch = document.getElementById("food-search");

const searchTerm = document.querySelector(".search-term");

const suggestedPairings = document.querySelector(".suggested-pairings");

const foodPairingsUl = document.getElementById("food-pairings");

const flavorAffinities = document.querySelector(".flavor-affinities");
const flipcardContainer = document.getElementById("flipcard-container");
const flavorAffinitiesUl = document.getElementById("flavor-affinities");
const buttons = document.querySelector(".buttons");

const displayFilters = function (ingredient) {
  let dietaryFilters = new Set();

  ingredient.pairings.forEach((pairing) => {
    dietaryFilters.add(pairing.dietaryFilter);
  });
  dietaryFilters.forEach((filter) => {
    const filterButton1 = document.createElement("button");
    filterButton1.innerText = filter;
    filterButton1.classList.add("filter-button");
    filterButton1.classList.add("fadein");
    filterButton1.style.display = "initial";

    setTimeout(() => {
      searchTerm.classList.remove("fadein");
      filterButton1.classList.remove("fadein");
      filterReset.classList.remove("fadein");
    }, 3000);

    buttons.appendChild(filterButton1);

    filterButton1.addEventListener("click", (e) => {
      const buttonArray = Array.from(
        document.querySelectorAll(".filter-button")
      );
      buttonArray.forEach((filterButton1) =>
        filterButton1.classList.remove("filter-button-active")
      );
      e.target.classList.add("filter-button-active");

      clearChildren(foodPairingsUl);

      fetch(
        `http://localhost:8080/api/ingredient/${ingredient.id}/pairing/dietaryFilter?filter=${filter}`
      )
        .then((response) => response.json())
        .then((pairings) => displayPairings(pairings));
    });
  });

  const filterReset = document.createElement("button");
  filterReset.innerText = "CLEAR";
  filterReset.classList.add("filter-button-clear");
  filterReset.classList.add("fadein");
  filterReset.style.display = "initial";
  buttons.appendChild(filterReset);
  filterReset.addEventListener("click", (e) => {
    const buttonArray = Array.from(
        document.querySelectorAll(".filter-button")
      );
      buttonArray.forEach((filterButton1) =>
        filterButton1.classList.remove("filter-button-active")
      );
    clearChildren(foodPairingsUl);
    suggestedPairings.style.display = "inherit";

    fetch(`http://localhost:8080/api/ingredient-name/${ingredient.ingredient}`)
      .then((response) => response.json())
      .then((ingredient) => displayPairings(ingredient.pairings))
      .catch((error) => console.log(error));
  });
};


const displayPairings = function(pairings) {
    pairings.forEach((pairing) => {
        const pairingList = document.createElement("li");
        if (pairing.textStyle == 1) {
            pairingList.style.fontWeight = "900";
        }
        if (pairing.textStyle == 3) {
            pairingList.style.fontStyle = "italic";
        }
        foodPairingsUl.append(pairingList);
        pairingList.classList.add("modal-button")
        pairingList.innerText = pairing.name;
        pairingList.style.display = "inherit";
        pairingList.id = `pairing${pairing.id}`
        suggestedPairings.classList.add("slidein");

        let outerDiv = document.createElement("div")
        outerDiv.classList.add("dropdown-content")
        outerDiv.classList.add("outer-div")
        outerDiv.id = `modals${pairing.id}`
        pairingList.appendChild(outerDiv)

        let middleDiv = document.createElement("div")
        middleDiv.classList.add("modal")
        middleDiv.classList.add("middle-div")
        middleDiv.id = `modal${pairing.id}`
        outerDiv.appendChild(middleDiv)

        let innerDiv = document.createElement("div")
        innerDiv.classList.add("modal-content")
        innerDiv.classList.add("inner-div")
        innerDiv.id = `inner-div-${pairing.id}`
        middleDiv.appendChild(innerDiv)

        let pairingSpan = document.createElement("span");
        pairingSpan.classList.add("close");
        pairingSpan.id = `close${pairing.id}`;
        pairingSpan.innerText = "X";
        innerDiv.appendChild(pairingSpan);

        let modalTitle = document.createElement("h2");
        modalTitle.innerText = pairing.name;
        modalTitle.classList.add("modal-title");
        innerDiv.appendChild(modalTitle)
        let modalList = document.createElement("ul");
        modalList.classList.add("modal-list");
        innerDiv.appendChild(modalList);
        let example = document.createElement("li")
        example.innerText = "example";
        modalList.appendChild(example);

        let fillList = function(ingredient) {
            ingredient.forEach((ingredient) => {
                let modalIngredient = document.createElement("p")
                modalIngredient.innerText = ingredient.ingredient
                modalList.appendChild(modalIngredient)
            })
        }

        fetch(`http://localhost:8080/api/pairings/${pairing.name}/ingredient`, {
                method: "GET",
                mode: "cors",
                headers: {
                    "Content-Type": "application/json",
                },
            })
            .then((response) => response.json())
            .then((ingredient) => fillList(ingredient))
            .catch((error) => console.log(error));

        function toggleModal() {
          middleDiv.classList.toggle("show-modal")
        }

        pairingList.addEventListener("click", toggleModal)

  });
};

const displayAffinities = function (ingredient) {
  // Card One

  const flipcard1 = document.createElement("div");
  flipcard1.classList.add("flipCard");
  flipcardContainer.appendChild(flipcard1);

  const card1 = document.createElement("div");
  card1.classList.add("card");
  card1.onclick = function () {
    this.classList.toggle("flipped");
  };
  flipcard1.appendChild(card1);

  const cardFront1 = document.createElement("div");
  cardFront1.classList.add("side");
  cardFront1.classList.add("front");
  cardFront1.innerText = ingredient.affinity1;
  card1.appendChild(cardFront1);

  const flipSymbol = document.createElement("img");
  flipSymbol.src = "./img/flip.webp";
  flipSymbol.classList.add("flip-symbol");
  cardFront1.appendChild(flipSymbol);

  const cardBack1 = document.createElement("div");
  cardBack1.classList.add("side");
  cardBack1.classList.add("back");
  card1.appendChild(cardBack1);

  const flipSymbolBack1 = document.createElement("img");
  flipSymbolBack1.src = "./img/flipBlack.webp";
  flipSymbolBack1.classList.add("flip-symbol");
  cardBack1.appendChild(flipSymbolBack1);

  const anchorDiv1 = document.createElement("div");
  anchorDiv1.classList.add("anchor-div");
  cardBack1.appendChild(anchorDiv1);

  const cardRecipe1 = document.createElement("a");
  cardRecipe1.target = "_blank";
  cardRecipe1.rel = "noopener noreferrer";
  cardRecipe1.href = ingredient.affinity1Url;
  anchorDiv1.appendChild(cardRecipe1);

  const recipeImage1 = document.createElement("img");
  recipeImage1.src = ingredient.affinity1Photo;
  recipeImage1.id = "affinity-1-img";
  cardRecipe1.appendChild(recipeImage1);

  const overlay1 = document.createElement("div");
  overlay1.classList.add("overlay");
  cardRecipe1.appendChild(overlay1);

  const overlayText1 = document.createElement("div");
  overlayText1.classList.add("text");
  overlayText1.innerText = "Click for Recipe";
  overlay1.appendChild(overlayText1);

  // Card Two

  const flipcard2 = document.createElement("div");
  flipcard2.classList.add("flipCard");
  flipcardContainer.appendChild(flipcard2);

  const card2 = document.createElement("div");
  card2.classList.add("card");
  card2.onclick = function () {
    this.classList.toggle("flipped");
  };
  flipcard2.appendChild(card2);

  const cardFront2 = document.createElement("div");
  cardFront2.classList.add("side");
  cardFront2.classList.add("front");
  cardFront2.innerText = ingredient.affinity2;
  card2.appendChild(cardFront2);

  const flipSymbol2 = document.createElement("img");
  flipSymbol2.src = "./img/flip.webp";
  flipSymbol2.classList.add("flip-symbol");
  cardFront2.appendChild(flipSymbol2);

  const cardBack2 = document.createElement("div");
  cardBack2.classList.add("side");
  cardBack2.classList.add("back");
  card2.appendChild(cardBack2);

  const flipSymbolBack2 = document.createElement("img");
  flipSymbolBack2.src = "./img/flipBlack.webp";
  flipSymbolBack2.classList.add("flip-symbol");
  cardBack2.appendChild(flipSymbolBack2);

  const anchorDiv2 = document.createElement("div");
  anchorDiv2.classList.add("anchor-div");
  cardBack2.appendChild(anchorDiv2);

  const cardRecipe2 = document.createElement("a");
  cardRecipe2.target = "_blank";
  cardRecipe2.rel = "noopener noreferrer";
  cardRecipe2.href = ingredient.affinity2Url;
  anchorDiv2.appendChild(cardRecipe2);

  const recipeImage2 = document.createElement("img");
  recipeImage2.src = ingredient.affinity2Photo;
  recipeImage2.id = "affinity-2-img";
  cardRecipe2.appendChild(recipeImage2);

  const overlay2 = document.createElement("div");
  overlay2.classList.add("overlay");
  cardRecipe2.appendChild(overlay2);

  const overlayText2 = document.createElement("div");
  overlayText2.classList.add("text");
  overlayText2.innerText = "Click for Recipe";
  overlay2.appendChild(overlayText2);
  //Card Three

  const flipcard3 = document.createElement("div");
  flipcard3.classList.add("flipCard");
  flipcardContainer.appendChild(flipcard3);

  const card3 = document.createElement("div");
  card3.classList.add("card");
  card3.onclick = function () {
    this.classList.toggle("flipped");
  };
  flipcard3.appendChild(card3);

  const cardFront3 = document.createElement("div");
  cardFront3.classList.add("side");
  cardFront3.classList.add("front");
  cardFront3.id = "affinity-3";
  cardFront3.innerText = ingredient.affinity3;
  card3.appendChild(cardFront3);

  const flipSymbol3 = document.createElement("img");
  flipSymbol3.src = "./img/flip.webp";
  flipSymbol3.classList.add("flip-symbol");
  cardFront3.appendChild(flipSymbol3);

  const cardBack3 = document.createElement("div");
  cardBack3.classList.add("side");
  cardBack3.classList.add("back");
  card3.appendChild(cardBack3);

  const flipSymbolBack3 = document.createElement("img");
  flipSymbolBack3.src = "./img/flipBlack.webp";
  flipSymbolBack3.classList.add("flip-symbol");
  cardBack3.appendChild(flipSymbolBack3);

  const anchorDiv3 = document.createElement("div");
  anchorDiv3.classList.add("anchor-div");
  cardBack3.appendChild(anchorDiv3);

  const cardRecipe3 = document.createElement("a");
  cardRecipe3.target = "_blank";
  cardRecipe3.rel = "noopener noreferrer";
  cardRecipe3.href = ingredient.affinity3Url;
  anchorDiv3.appendChild(cardRecipe3);

  const recipeImage3 = document.createElement("img");
  recipeImage3.src = ingredient.affinity3Photo;
  recipeImage3.id = "affinity-3-img";
  cardRecipe3.appendChild(recipeImage3);

  const overlay3 = document.createElement("div");
  overlay3.classList.add("overlay");
  cardRecipe3.appendChild(overlay3);

  const overlayText3 = document.createElement("div");
  overlayText3.classList.add("text");
  overlayText3.innerText = "Click for Recipe";
  overlay3.appendChild(overlayText3);
  flavorAffinities.style.visibility = "visible";
  flavorAffinities.classList.add("slideup");
};

foodSearch.addEventListener("keydown", function (event) {
  if (event.code === "Enter") {
    searchTerm.innerText = foodSearch.value;
    let searchFood = foodSearch.value.toLowerCase();
    searchTerm.style.display = "inherit";
    searchTerm.classList.add("fadein");

    clearChildren(foodPairingsUl);
    clearChildren(flipcardContainer);
    clearChildren(buttons);
    suggestedPairings.classList.remove("slidein");
    flavorAffinities.classList.remove("slideup");
    suggestedPairings.style.display = "inherit";

    fetch(`http://localhost:8080/api/ingredient-name/${searchFood}`, {
      method: "GET",
      mode: "cors",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((ingredient) => displayFilters(ingredient))
      .catch((error) => console.log(error));

    fetch(`http://localhost:8080/api/ingredient-name/${searchFood}`, {
      method: "GET",
      mode: "cors",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((ingredient) => displayPairings(ingredient.pairings))
      .catch((error) => console.log(error));

    fetch(`http://localhost:8080/api/ingredient-name/${searchFood}`, {
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
};