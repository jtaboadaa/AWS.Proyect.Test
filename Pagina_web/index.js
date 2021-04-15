const path = require('path');
const express = require('express');
const app = require();

const SocketIO = require('socket.io');
SocketIO(server);
const io = SocketIO;

// websockets

io.on('connection', () => {
    console.log('new connection');  
})
// settings
app.set('port', process.eventNames.PORT || 1337 );

// static files


app.use(express.static(console.log(path.join(__dirname, index.html))));

// start server 
app.listen(app.get('port'), (socket) => {
    console.log('server on port', app.get('port'));
});

// websocket

const SocketIO = require('socket.io');
const io = SocketIO(server);

io.on('connection', (socket) =>
{
    console.log('new connection', socket.id);
    
})