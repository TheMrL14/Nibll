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
    $.getJSON("http://nibll.local:5001/send?protocol=kaku_switch&id=5218304&unit=1&repeat=5&off=1")
    .done(function (data) {
      if(data.message == "success"){
        tempDevice.status = false;
        postToDatabase(tempDevice);
      }
    });
  }else {
    $.getJSON("http://nibll.local:5001/send?protocol=kaku_switch&id=5218304&unit=1&repeat=5&on=1")
    .done(function (data) {
      if(data.message == "success"){
        tempDevice.status = true;
        postToDatabase(tempDevice);
      }
    });
  }
  console.log(JSON.stringify(tempDevice))
}

function postToDatabase(tempDevice){
  $.post("http://localhost:8080/device/Post", tempDevice);
}
