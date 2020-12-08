import {
    displayPosts,
    populateDropDown
} from "./post.js"


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





const button = document.getElementById("submit-post");
let ingredientInput = document.getElementById("dropdown");
let hashtagInput = document.getElementById("hashtag");
let recipeNameInput = document.getElementById("recipe-name");
let linkInput = document.getElementById("link");
let photoInput = document.getElementById("photo");

let today = new Date();
let date = (today.getMonth()+1)+'/'+today.getDate()+'/'+today.getFullYear();

button.addEventListener("click", () => {
    console.log("hello");
    console.log(ingredientInput, hashtagInput, recipeNameInput, linkInput, photoInput)
    const postJson = {
        "ingredient": ingredientInput.value,
        "recipeName": recipeNameInput.value,
        "recipeLink": linkInput.value,
        "hashtag": hashtagInput.value,
        "photo": photoInput.value,
        "timeStamp": date
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
        .then(location.reload());
})


fetch(`http://localhost:8080/api/ingredients`, {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((ingredient) => populateDropDown(ingredient))
    .catch((error) => console.log(error));