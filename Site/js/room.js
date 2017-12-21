var GET = {};
var room;

$(function() {
  getInfo();
  if(GET == {}){
    window.location = "rooms.html"
  }
  getRoom();
  console.log(GET)
});

function getRoom() {
  room = $.getJSON("http://localhost:8080/kamer/getById?id=" + GET.id, function(data){
    console.log(data)
  });
}

function getInfo(){
var query = window.location.search.substring(1).split("&");
for (var i = 0, max = query.length; i < max; i++)
{
    if (query[i] === "") // check for trailing & with no param
        continue;

    var param = query[i].split("=");
    GET[decodeURIComponent(param[0])] = decodeURIComponent(param[1] || "");
}
}
