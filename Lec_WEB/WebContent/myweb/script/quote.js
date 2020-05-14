$(document).ready(function(){
    $.ajax({
        url : "http://quotes.stormconsultancy.co.uk/random.json",
        type : "GET",
        cache : false,
        success : function(data, status){
            if(status == "success") parseJSON(data);

        }

    });
});

function parseJSON(data){   

    var $author = $("#side_content").find("h4");
    var $quote = $("#main_content").find("h6");

           
    $author.css({'opacity' : 0});
    $quote.css({'opacity' : 0});

    $author.text(data.author);
    $quote.text(data.quote);

    $quote.animate({'opacity' : 1}, 1000);

    $.when($quote).then(function(){
        $author.animate({'opacity' : 1}, 1000);
    }).then(function(){
        $author.animate({'top' : 5}, 300);
    }).then(function(){
        $author.animate({'top' : 0}, 300);
    });
    
    
}