const mysql = require('mysql');
const squel = require('squel');

let conexion = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'taxi'
});

conexion.connect;

let consulta = squel.select()
    .field('latitud')
    .field('longitud')
    .field('tiempo');

console.log('Consulta SQL:', consulta.toString());

conexion.query(consulta.toString(), function(error, registros, campos){
    if (error){
        throw(error)
    }
    registros.forEach(function(registro, indice, arreglo){
        const latitud = console.log('latitud:', registro.latitud);
        const longitud = console.log('longitud:', registro.longitud);
        const tiempo = console.log('tiempo:', registro.tiempo);
    })
conexion.end();
});