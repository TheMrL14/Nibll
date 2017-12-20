var activities;

window.addEventListener("load", laadActivities);

function laadActivities() {
  var activities = $.getJSON("http://localhost:8080/test/getAllActiviteit", function(data) {
      var htmlString = "";
    data.forEach(function(activity){
      htmlString += '<li class="roomsTile" activityId="' + activity.activiteitId;
      htmlString += '"><h3>'
      htmlString += activity.naamActiviteit + '</h3></li>'
    });
      $(".activities-container").html(htmlString);
      $(".activitiesTile").on("click", function (event) {
      });
  });
}
