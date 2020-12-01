import { allPosts } from "./samplePostJSON"

const mainElement = document.getElementById("posts")

fetch("http://localhost:8080/api/posts", {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((albums) => displayHomeView(albums))
    .then((mainElement) => mainElement.appendChild(displayHomeView))
    .catch((error) => console.log(error));