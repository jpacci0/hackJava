//! DOM -> Document Object Model
// console.dir(document)

//! html, head, body
//* prendere gli elementi
// let title = document.querySelector('#title');
// console.log(title.style.backgroundColor)
// title.style.backgroundColor = 'green';

//* addEventListener
//* collegare un evento ( un'azione che avviene nel browser ( click, mousover, moueleave))
// let btn = document.querySelector('#btn');
// function onclickfunction() { console.log('cliccato') }
// btn.addEventListener('click', onclickfunction)

//* innerHTML -> ci permette di modicifare il contenuto di HTML di un tag
// let title = document.querySelector('#title');
// setTimeout(() => {
//     title.innerHTML = 'ciaone';
// }, 3000);
//* createElement

fetch('https://api.rawg.io/api/games?key=9af72c943356453fb08b37b3f1f9a18a')
.then(resp => resp.json())
.then(data => {
    console.log(data)
    renderGames(data.results);
    renderCategories(data.results);
    
});

function renderGames(games){
    let gamesContainer = document.querySelector('#gamesContainer');

    games.forEach(game => {

        let col = document.createElement('div');
        col.classList.add('col-12', 'col-md-4', 'my-2');
        col.innerHTML = `
            <div class="card altezzaCard">
            <img src="${game.background_image}" class="card-img-top" alt="${game.name}">
            <div class="card-body">
            <h5 class="card-title">${game.name}</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            </div>
        `;
        gamesContainer.appendChild(col);
    }); 

    let reset = document.querySelector('#reset');
    reset.addEventListener('click', () => {
        gamesContainer.innerHTML = ""
        renderGames(games);
        let categorycontainer = document.querySelector('#categorycontainer');
        categorycontainer.value = ""
    })
}

/* <li><a class="dropdown-item" href="#">Action</a></li> */
function renderCategories(games) {
    let categories = Array.from(
        new Set(games.map(game => game.genres)
        .map(el => el.map(x => x.name))
        .flat())
        );
        
        let categorycontainer = document.querySelector('#categorycontainer');
        let gamesContainer = document.querySelector('#gamesContainer');
        
        categories.forEach(category => {
            let option = document.createElement('option');
            option.value = category;
            option.innerHTML = category;
            categorycontainer.appendChild(option);
        });
        
        categorycontainer.addEventListener('change', (event) => {
            let selectedCategory = event.target.value;
            let gamesByCategory = games.filter(game => {
                return game.genres.some(genre => genre.name === selectedCategory);
            });
            gamesContainer.innerHTML = "";
            gamesByCategory.forEach(game => {
                let gameElem = document.createElement('div');
                gameElem.classList.add('col-12', 'col-md-4', 'my-2');
                gameElem.innerHTML = `
                    <div class="card altezzaCard">
                    <img src="${game.background_image}" class="card-img-top" alt="${game.name}">
                    <div class="card-body">
                    <h5 class="card-title">${game.name}</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    </div>
                    </div>
                `;
                gamesContainer.appendChild(gameElem);
            });
        });
}
    
    