const path = require('path');
const { Server } = require('engine.io');
const express = require('express');
const app =express();


//setting 
app.set('port', process.env.PORT || 1337);

//Statics files
app.use(express.static(path.join(__dirname, 'Pagina_web')));

//Start the server
const server = app.listen(app.get('port'),() => {
    console.log('server on port',app.get('port'));
});

//websockets
const SocketIO = require('socket.io');
const io = SocketIO(server);

io.on('connection', () => {
    console.log('new connecion', socket.id);
});





