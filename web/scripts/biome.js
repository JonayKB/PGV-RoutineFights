const getItemsButton = document.getElementById('getBiomes');
const getItemByIdButton = document.getElementById('getBiomeById');
const deleteItemByIdButton = document.getElementById('deleteBiomeById');
const postItem = document.getElementById('postBiome');
let getItemByIdText = document.getElementById('idBiome');
let deleteByIdText = document.getElementById('idBiomeDelete');
let nameText = document.getElementById('name');
let spawnMobsText = document.getElementById('spawnMobs');
let dimensionIdText = document.getElementById('dimensionId');
getItemsButton.addEventListener('click', fetchInfoItems);
getItemByIdButton.addEventListener('click', fetchInfoItem);
deleteItemByIdButton.addEventListener('click', fetchDeleteItem);
postItem.addEventListener('click', fetchPostItem);
const itemZone = document.getElementById('biome');
const itemsZone = document.getElementById('biomes');
const itemPostZone = document.getElementById('biomePosted');

function fetchInfoItems() {
    let url = 'http://localhost:25565/api-rest/biome/';
    fetchGetUrl(url);
}
function fetchPostItem() {
    let url = 'http://localhost:25565/api-rest/biome/'
    fetchPostUrl(url);
}
function fetchDeleteItem() {
    let url = 'http://localhost:25565/api-rest/biome/'
    fetchDeleteUrl(url, deleteByIdText.value);
}
function fetchDeleteUrl(url, id) {
    console.log(url + id)
    fetch(url + id, {
        method: "DELETE"
    })

}

function fetchPostUrl(url) {
    const mobs = spawnMobsText.value.split(',');

    let mobsIdsFormat = [];
    mobs.forEach(mob => {
        mobsIdsFormat.push({ id: mob })
    });
    console.log(mobsIdsFormat)
    let response = fetch(url, {
        method: "POST",
        body: JSON.stringify({
            name: nameText.value,
            spawnMobs: mobsIdsFormat,
            dimensionId: dimensionIdText.value
        }),
        headers: {
            "Content-type": "application/json; charset=UTF-8"
        }
    });
    response.then(response => response.json()).then(jsonObj => displayItem(jsonObj, itemPostZone))
}

function fetchInfoItem() {
    let url = 'http://localhost:25565/api-rest/biome/' + getItemByIdText.value;
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

function displayItems(biomes) {
    let objects = ``

    biomes.forEach(biome => {
        let mobs = ``
        biome.spawnMobs.forEach(mob => {
            mobs += mob.id + ",";
        })
        mobs = mobs.slice(0, -1)
        objects += `<tr>
        <td>${biome.id}</td>
        <td>${biome.name}</td>
        <td>${mobs}</td>
        <td>${biome.dimensionId}</td>
        </tr>`
    });
    const templateItems = `
    <div>
    <table>
    <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>SPAWN MOBS</th>
    <th>DIMENSION ID</th>
    `+ objects + `
    </tr>
    </table>
    
    </div>
    `
    itemsZone.innerHTML = templateItems;

}

function displayItem(biome, zone) {
    console.log(biome)
    let mobs = ``
    biome.spawnMobs.forEach(mob => {
        mobs += mob.id + ",";
    })
    mobs = mobs.slice(0, -1)
    const objects = `<tr>
        <td>${biome.id}</td>
        <td>${biome.name}</td>
        <td>${mobs}</td>
        <td>${biome.dimensionId}</td>
        </tr>`
    const templateItems = `
    <div>
    <table>
    <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>SPAWN MOBS</th>
    <th>DIMENSION ID</th>
    `+ objects + `
    </tr>
    </table>
    
    </div>
    `
    zone.innerHTML = templateItems;
}