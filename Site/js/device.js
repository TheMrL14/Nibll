var device;

$(function () {
  window.setInterval(getDevice, 1000);
  $("#deviceToggleButton").on("click", setDevice);
});

function getDevice() {
$.getJSON("http://localhost:8080/device/getById?id=1", function(data) {
  device = data;
console.log(data);
if(data.status){
  $("#deviceToggleButton").attr("value", "Aan");
  console.log("lol");
}else {
  $("#deviceToggleButton").attr("value", "Uit");
  console.log("l");
}
});
}

function setDevice () {
  console.log(device)
  var tempDevice = device;
  if($("#deviceToggleButton").attr("value") == "Aan") {
    tempDevice.status = false;
  }else {
    tempDevice.status = true;
  }
  console.log(JSON.stringify(tempDevice))
  $.post("http://localhost:8080/device/Post", tempDevice)
  .fail(function(e){
    console.log(e)
  });
}
