const tilesProvider ='https://{s}.tile.openstreetmap.de/{z}/{x}/{y}.png'
// Cambiar coordenadas por la última de la base de datos
let myMap = L.map('myMap').setView([10.4206,-75.5454],15)

L.tileLayer(tilesProvider, {
    maxZoom: 18,
}).addTo(myMap)

let marker = L.marker([10.42284, -75.5493]).addTo(myMap)
let marker2 = L.marker([10.4178,  -75.5413]).addTo(myMap)




