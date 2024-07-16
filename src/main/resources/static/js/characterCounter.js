var text_max = 201;
$('#count_message').html('0 / ' + text_max);

$('#text').keyup(function () {
    var text_length = $('#text').val().length;
    var text_remaining = text_max - text_length;

    $('#count_message').html(text_length + ' / ' + text_max);
});

function validate(){
    const areatextarea = document.querySelector("#summary");
    const areatext = document.querySelector("#summary").value.length;
    const textcount = document.querySelector("#textcount");
    const wordcount = document.querySelector("#words_count");
    textcount.innerHTML = areatext;


    if(areatext > 50){
        textcount.classList.add("text-danger");
        areatextarea.classList.add("textarea_danger");
    }else{
        textcount.classList.remove("text-danger");
        areatextarea.classList.remove("textarea_danger");
    }

    if(areatext < 1){
        wordcount.classList.add("d-none");
    }else{
        wordcount.classList.remove("d-none");
    }
}