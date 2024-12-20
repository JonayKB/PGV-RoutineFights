const getItemsButton = document.getElementById('getItems');
const getItemByIdButton = document.getElementById('getItemById');
const deleteItemByIdButton = document.getElementById('deleteItemById');
const postItem = document.getElementById('postItem');
let getItemByIdText = document.getElementById('idItem');
let deleteByIdText = document.getElementById('idItemDelete');
let nameMobText = document.getElementById('name');
let playersIdsText = document.getElementById('playersIds');
let mobIdsText = document.getElementById('mobIds');
getItemsButton.addEventListener('click', fetchInfoItems);
getItemByIdButton.addEventListener('click', fetchInfoItem);
deleteItemByIdButton.addEventListener('click', fetchDeleteItem);
postItem.addEventListener('click', fetchPostItem);
const itemZone = document.getElementById('item');
const itemsZone = document.getElementById('items');
const itemPostZone = document.getElementById('itemPosted');

function fetchInfoItems() {
    let url = 'http://localhost:25565/api-rest/item/';
    fetchGetUrl(url);
}
function fetchPostItem() {
    let url = 'http://localhost:25565/api-rest/item/'
    fetchPostUrl(url);
}
function fetchDeleteItem() {
    let url = 'http://localhost:25565/api-rest/item/'
    fetchDeleteUrl(url, deleteByIdText.value);
}
function fetchDeleteUrl(url, id) {
    console.log(url + id)
    fetch(url + id, {
        method: "DELETE"
    })

}

function fetchPostUrl(url) {
    const players = playersIdsText.value.split(',');
    const mobs = mobIdsText.value.split(',');
    let playerIdsFormat = [];
    let mobsIdsFormat = [];
    players.forEach(item => {
        playerIdsFormat.push(parseInt(item))
    });
    mobs.forEach(biome => {
        mobsIdsFormat.push(parseInt(biome))
    });

    let response = fetch(url, {
        method: "POST",
        body: JSON.stringify({
            name: nameMobText.value,
            playersIds: playerIdsFormat,
            mobsIds: mobsIdsFormat
        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });
    response.then(response => response.json()).then(jsonObj => displayItem(jsonObj, itemPostZone))
}

function fetchInfoItem() {
    let url = 'http://localhost:25565/api-rest/item/' + getItemByIdText.value;
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

function displayItems(items) {
    let objects = ``

    items.forEach(item => {
        objects += `<tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.playersIds}</td>
        <td>${item.mobsIds}</td>
        </tr>`
    });
    const templateItems = `
    <div>
    <table>
    <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>PLAYER IDS</th>
    <th>MOBS IDS</th>
    `+ objects + `
    </tr>
    </table>
    
    </div>
    `
    itemsZone.innerHTML = templateItems;

}

function displayItem(item, zone) {
    console.log(item)
    const objects = `<tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.playersIds}</td>
        <td>${item.mobsIds}</td>
        </tr>`
    console.log(objects)
    const templateItem = `
    <div>
    <table>
    <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>PLAYER IDS</th>
    <th>MOBS IDS</th>
    `+ objects + `
    </tr>
    </table>
    
    </div>
    `
    console.log(templateItem)
    zone.innerHTML = templateItem;
}