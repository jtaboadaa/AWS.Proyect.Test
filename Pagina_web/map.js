const tilesProvider ='https://{s}.tile.openstreetmap.de/{z}/{x}/{y}.png'

let myMap = L.map('myMap').setView([10.422835,-75.549274],13)

L.tileLayer(tilesProvider, {
    maxZoom: 18,
}).addTo(myMap)

let marker = L.marker([10.422835, -75.549274]).addTo(myMap)





