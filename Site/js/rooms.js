var rooms;

window.addEventListener("load", laadKamers);

function laadKamers() {
  rooms = $.getJSON("http://192.168.1.128:8080/kamer/getAll", function(data) {
      var htmlString = "";
    data.forEach(function(kamer){
      htmlString += '<li class="roomsTile" kamerId="' + kamer.kamerId;
      htmlString += '"><h3>'
      htmlString += kamer.naamKamer + '</h3></li>'
    });
      $(".rooms-container").html(htmlString);
      $(".roomsTile").on("click", function (event) {
        console.log(this.getAttribute("kamerId"));
        window.location = "room.html?id=" + this.getAttribute("kamerId");
      });
  });
}
