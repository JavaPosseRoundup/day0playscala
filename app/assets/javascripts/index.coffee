$ ->
  $.get "/listBars", (data) ->
    $.each data, (i, bar) ->
      $("#bars").append "<li>" + bar.name + "</li>"