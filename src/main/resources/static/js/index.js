$("#submit").on('click', function(){
    console.log(window.location.hostname + "/users/" + $("#name").textContent);
    $.ajax({
        type: 'PUT',
        url: window.location.hostname + "/users/" + $("#name").textContent
    });
});