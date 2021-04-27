// Server
const dgram = requiere('dgram');

const server = dgram.createSocket('udp4');

server.on('listening', () => console.log('UDP Server listening'));

server.on('message', (msg, rinfo) => {
    console.log(`${rinfo.address}:${rinfo.port} - ${msg}`);
});

const PORT = 222;
const HOST = 'ip';
server.bind(PORT, HOST);

// Cliente

setInterval(function () {

    const client = dgram.createSocket('udp4');

client.send('Pluralsight rocks', PORT, HOST, (err) => {
if (err) throw err;

console.log('UDP message sent');
client.close();

});

}, 1000)
