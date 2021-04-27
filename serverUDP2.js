  var dgram = require('dgram');

var server = dgram.createSocket('udp4');

server.on('message',function(msg, rinfo){
	console.log('I received this message from client: ' + msg);
});

server.bind(37777);