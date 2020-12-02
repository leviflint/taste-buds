import { allPosts } from "./samplePostJSON.js"
import {displayPosts} from "./post.js"




fetch("http://localhost:8080/api/post", {
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