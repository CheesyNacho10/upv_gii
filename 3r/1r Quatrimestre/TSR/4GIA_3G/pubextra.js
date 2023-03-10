// pubextra.js
var zmq = require('zeromq')
var publisher = zmq.socket('pub')

// Check how many arguments have been received.
if (process.argv.length < 5) {
  console.error("Format is 'node pubextra URL secs topics+'")
  console.error("Example: 'node pubextra tcp://*:9999 2 deporte ciencia sociedad'")
  process.exit(1)
}
// Get the connection URL.
var url = process.argv[2]
// Get period
var period = process.argv[3]
// Get topics
var topics = process.argv.slice(4)
var i=0
var count=0
publisher.bind(url, function(err) {
  if(err) console.log(err);
  else console.log('Listening on '+url+' ...')
})

setInterval(function() {
  ++count
  publisher.send(topics[i]+' msg '+count)
  console.log('Sent '+topics[i]+' msg '+count)
  i=(i+1)%topics.length
  // Uncommet next line in order to stop when 100 messages have been sent.
  //if (count>100) process.exit()
},period*1000);

