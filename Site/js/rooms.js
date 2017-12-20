var rooms;

window.addEventListener("load", laadKamers);

function laadKamers() {
  rooms = $.getJSON("http://localhost:8080/test/getAllKamer", function(data) {
      var htmlString = "";
    data.forEach(function(kamer){
      htmlString += '<li class="roomsTile" kamerId="' + kamer.kamerId;
      htmlString += '"><h3>'
      htmlString += kamer.naamKamer + '</h3></li>'
    });
      $(".rooms-container").html(htmlString);
      $(".roomsTile").on("click", function (event) {
        console.log(this.getAttribute("kamerId"));
      });
  });
}
