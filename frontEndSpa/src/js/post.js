const displayPosts = function (allPosts) {
    const element = document.getElementById("search")
    const mainElemenet = document.createElement("div");
    mainElemenet.id = ("posts");
    element.appendChild(mainElemenet);

    allPosts.forEach((post) => {
        let outerDiv = document.createElement("div");
        outerDiv.classList.add("post");
        mainElemenet.appendChild(outerDiv);

        let image = document.createElement("img");
        image.alt = ("photo");
        image.src = post.photo;
        outerDiv.appendChild(image);
        
        let innerDiv = document.createElement("div");
        innerDiv.classList.add("post-text");
        outerDiv.appendChild(innerDiv);

        let ingredient = document.createElement("p");
        ingredient.classList.add("ingredient");
        ingredient.innerText = post.ingredient;
        innerDiv.appendChild(ingredient);

        let recipe = document.createElement("p");
        recipe.classList.add("recipe");
        innerDiv.appendChild(recipe);

        let recipeLink = document.createElement("a");
        recipeLink.href = post.recipeLink;
        recipeLink.target = "_blank";
        recipeLink.innerText = post.recipeName;
        recipe.appendChild(recipeLink);

        let hashtag = document.createElement("p");
        hashtag.classList.add("hashtag");
        hashtag.innerText = post.hashtag;
        innerDiv.appendChild(hashtag);

        let timestamp = document.createElement("p");
        timestamp.classList.add("timestamp");
        timestamp.innerText = "12/2/2020";
        innerDiv.appendChild(timestamp);
    


    })
    return mainElemenet;
}
export {displayPosts}