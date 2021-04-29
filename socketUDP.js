// Server
const dgram = require('dgram');

const server = dgram.createSocket('udp4');

server.on('listening', () => console.log('UDP Server listening'));

server.on('message', (msg, rinfo) => {
    console.log(`${rinfo.address}:${rinfo.port} - ${msg}`);
});

const PORT = 37777;
const HOST = '54.144.9.5';
server.bind(PORT, HOST);

// Cliente

setInterval(function () {

    const client = dgram.createSocket('udp4');

client.send('holis', PORT, HOST, (err) => {
if (err) throw err;

console.log('UDP message sent');
client.close();

});

}, 1000)
