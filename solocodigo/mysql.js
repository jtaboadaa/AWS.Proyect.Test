const mysql = require('mysql')

const conection = mysql.createConnection({
    host:'localhost',
    user:'Manuel',
    password:'php',
    database:'usuarios'

})

conection.connect( (err) =>{
    if(err) throw err
    console.log("la conexion funciona")


})
conection.query('SELECT * from users', (err, rows) =>{
    if(err) throw err
    console.log('Los datos de la tabla son estos: ')
    console.log(rows)
    console.log('la cantidad de resultados es: ')
    console.log(rows.length)
    const usuarioUno = rows[0]
    console.log(`El usuario se llama ${usuarioUno.nombre} y tiene el id ${usuarioUno.ID}`)


})

conection.end()