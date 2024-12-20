const getItemsButton = document.getElementById('getPlayers');
const getItemByIdButton = document.getElementById('getPlayerById');
const deleteItemByIdButton = document.getElementById('deletePlayerById');
const postItem = document.getElementById('postPlayer');
let getItemByIdText = document.getElementById('idPlayer');
let deleteByIdText = document.getElementById('idPlayerDelete');
let usernameText = document.getElementById('username');
let nicknameText = document.getElementById('nickname');
let passwordText = document.getElementById('password');
let levelText = document.getElementById('level');
let itemsIdsText = document.getElementById('itemsIds');
getItemsButton.addEventListener('click', fetchInfoItems);
getItemByIdButton.addEventListener('click', fetchInfoItem);
deleteItemByIdButton.addEventListener('click', fetchDeleteItem);
postItem.addEventListener('click', fetchPostItem);
const itemZone = document.getElementById('player');
const itemsZone = document.getElementById('players');
const itemPostZone = document.getElementById('playerPosted');

function fetchInfoItems() {
    let url = 'http://localhost:25565/api-rest/player/';
    fetchGetUrl(url);
}
function fetchPostItem() {
    let url = 'http://localhost:25565/api-rest/player/'
    fetchPostUrl(url);
}
function fetchDeleteItem() {
    let url = 'http://localhost:25565/api-rest/player/'
    fetchDeleteUrl(url, deleteByIdText.value);
}
function fetchDeleteUrl(url, id) {
    console.log(url + id)
    fetch(url + id, {
        method: "DELETE"
    })

}

function fetchPostUrl(url) {
    const items = itemsIdsText.value.split(',');
    console.log(items)
    console.log(itemsIdsText.value)

    let itemsIdsFormat = [];
    items.forEach(item => {
        itemsIdsFormat.push({id:item} )
    });
    console.log(itemsIdsFormat)
    let response = fetch(url, {
        method: "POST",
        body: JSON.stringify({
            username: usernameText.value,
            nickname: nicknameText.value,
            password: passwordText.value,
            level: levelText.value,
            items: itemsIdsFormat
        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });
    response.then(response => response.json()).then(jsonObj => displayItem(jsonObj, itemPostZone))
}

function fetchInfoItem() {
    let url = 'http://localhost:25565/api-rest/player/' + getItemByIdText.value;
    fetchGetUrl(url);
}
function fetchGetUrl(url) {
    fetch(url)
        .then(response => response.json())
        .then(jsonObj => displayForType(jsonObj))
        .catch(() => alert('La respuesta no ha sido valida'));
}

function displayForType(object) {
    if (object.length > 1) {
        displayItems(object)
    } else {
        displayItem(object, itemZone)
    }
}

function displayItems(players) {
    let objects = ``

    players.forEach(player => {
        let items = ``
        player.items.forEach(item => {
            items += item.id + ",";
        })
        items = items.slice(0,-1)
        objects += `<tr>
        <td>${player.id}</td>
        <td>${player.nickname}</td>
        <td>${player.username}</td>
        <td>${player.password}</td>
        <td>${player.level}</td>
        <td>${items}</td>
        </tr>`
    });
    const templateItems = `
    <div>
    <table>
    <tr>
    <th>ID</th>
    <th>NICKNAME</th>
    <th>USERNAME</th>
    <th>PASSWORD</th>
    <th>LEVEL</th>
    <th>ITEMS</th>
    `+ objects + `
    </tr>
    </table>
    
    </div>
    `
    itemsZone.innerHTML = templateItems;

}

function displayItem(player, zone) {
    console.log(player)
    let items = ``
        player.items.forEach(item => {
            items += item.id + ",";
        })
        items = items.slice(0,-1)
        objects = `<tr>
        <td>${player.id}</td>
        <td>${player.nickname}</td>
        <td>${player.username}</td>
        <td>${player.password}</td>
        <td>${player.level}</td>
        <td>${items}</td>
        </tr>`
    const templateItems = `
    <div>
    <table>
    <tr>
    <th>ID</th>
    <th>NICKNAME</th>
    <th>USERNAME</th>
    <th>PASSWORD</th>
    <th>LEVEL</th>
    <th>ITEMS</th>
    `+ objects + `
    </tr>
    </table>
    
    </div>
    `
    zone.innerHTML = templateItems;
}