function sleep(d) {
  var t = Date.now();
  while (Date.now - t <= d);
}

module.exports = {
  sleep: sleep
}