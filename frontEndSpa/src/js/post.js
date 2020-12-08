const displayPosts = function(post) {
    const element = document.getElementById("search")
    const mainElemenet = document.createElement("div");
    mainElemenet.id = ("posts");
    element.appendChild(mainElemenet);

    post.forEach((indvPost) => {
        let outerDiv = document.createElement("div");
        outerDiv.classList.add("post");
        mainElemenet.appendChild(outerDiv);

        let image = document.createElement("img");
        image.alt = ("photo");
        image.classList.add(post - photo);
        image.src = indvPost.photo;
        outerDiv.appendChild(image);

        let innerDiv = document.createElement("div");
        innerDiv.classList.add("post-text");
        outerDiv.appendChild(innerDiv);

        let ingredient = document.createElement("p");
        ingredient.classList.add("ingredient");
        ingredient.innerText = indvPost.ingredient;
        innerDiv.appendChild(ingredient);

        let recipe = document.createElement("p");
        recipe.classList.add("recipe");
        innerDiv.appendChild(recipe);

        let recipeLink = document.createElement("a");
        recipeLink.href = indvPost.recipeLink;
        recipeLink.target = "_blank";
        recipeLink.innerText = indvPost.recipeName;
        recipe.appendChild(recipeLink);

        let hashtag = document.createElement("p");
        hashtag.classList.add("hashtag");
        hashtag.innerText = indvPost.hashtag;
        innerDiv.appendChild(hashtag);

        let timestamp = document.createElement("p");
        timestamp.classList.add("timestamp");
        timestamp.innerText = indvPost.timeStamp;
        innerDiv.appendChild(timestamp)
    });

    return mainElemenet;
}

const populateDropDown = function(ingredients) {
    let dropDownMenu = document.getElementById("dropdown");

    ingredients.forEach((ingredient) => {
        let ingredientOption = document.createElement("option")
        ingredientOption.value = ingredient.ingredient;
        ingredientOption.innerText = ingredient.ingredient;
        dropDownMenu.appendChild(ingredientOption)
    })
}

export { displayPosts }
export { populateDropDown }