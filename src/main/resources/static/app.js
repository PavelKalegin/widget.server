var stompClient = null;

function setConnected(connected)
{
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#visitors").html("");
}


function connect() {
    console.log("trying to connect");
    var socket = new SockJS('/ws-visitors');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/customer/visitors', function (visitor) {
            showVisitors(JSON.parse(visitor.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    console.log(JSON.stringify({'id': $("#id").val(), 'name': $("#name").val()}));
    stompClient.send("/app/visitor.add", {}, JSON.stringify({'id': $("#id").val(), 'name': $("#name").val()}));
}

function showVisitors(visitors) {
    $("#visitors").append("<tr><td>" + visitors + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});