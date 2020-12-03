import { displayPosts } from "./post.js"




fetch("http://localhost:8080/api/posts", {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((posts) => displayPosts(posts))
    // .then((mainElement) => mainElement.appendChild(displayPosts))
    .catch((error) => console.log(error));

displayPosts()

let button = document.getElementById("submit");
let ingredientInput = document.getElementById("dropdown").value;
let hashtagInput = document.getElementById("hashtag").value;
let recipeNameInput = document.getElementById("recipe-name").value;
let linkInput = document.getElementById("link").value;
let photoInput = document.getElementById("photo").value;


button.addEventListener("click", () => {

    const postJson = {
        "ingredient": ingredientInput,
        "recipeName": recipeNameInput,
        "recipeLink": linkInput,
        "hashtag": hashtagInput,
        "photo": photoInput
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
        .then(posts => displayPosts(posts))
        .then(location.reload());
})