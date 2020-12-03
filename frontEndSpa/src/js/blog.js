import { displayPosts } from "./post.js"




fetch("http://localhost:8080/api/posts", {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((post) => displayPosts(post))
    .catch((error) => console.log(error));

// displayPosts(post)


// fetch(`http://localhost:8080/api/ingredient-name/${foodSearch.value}`, {
//     method: "GET",
//     mode: "cors",
//     headers: {
//         "Content-Type": "application/json",
//     },
// })
// .then((response) => response.json())
// .then((ingredient) => displayFilters(ingredient))
// .catch((error) => console.log(error));



const button = document.getElementById("submit-post");
let ingredientInput = document.getElementById("dropdown");
let hashtagInput = document.getElementById("hashtag");
let recipeNameInput = document.getElementById("recipe-name");
let linkInput = document.getElementById("link");
let photoInput = document.getElementById("photo");


button.addEventListener("click", () => {
    console.log("hello");
    console.log(ingredientInput, hashtagInput, recipeNameInput, linkInput, photoInput)
    const postJson = {
        "ingredient": ingredientInput.value,
        "recipeName": recipeNameInput.value,
        "recipeLink": linkInput.value,
        "hashtag": hashtagInput.value,
        "photo": photoInput.value
    }
    fetch("http://localhost:8080/api/post", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(postJson)
        })
        .then(response => response.json())
        .catch(err => console.error(err))
        // .then(posts => displayPosts(posts))
        .then(location.reload());
})