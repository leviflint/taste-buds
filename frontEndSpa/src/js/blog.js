import { allPosts } from "./samplePostJSON.js"
import {displayPosts} from "./post.js"

const mainElement = document.getElementById("search")
mainElement.appendChild(displayPosts);

// fetch("http://localhost:8080/api/posts", {
//         method: "GET",
//         mode: "cors",
//         headers: {
//             "Content-Type": "application/json",
//         },
//     })
//     .then((response) => response.json())
//     .then((posts) => displayPosts(posts))
//     .then((mainElement) => mainElement.appendChild(displayPosts))
//     .catch((error) => console.log(error));