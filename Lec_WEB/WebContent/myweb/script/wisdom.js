
$(document).ready(function(){
    connectAPI();
});

function connectAPI() {
    $.ajax({
        url : "https://api.quotable.io/random",
        type : "GET",
        cache : false,
        success : function(data, status){
            if(status == "success") {
                
                parseJSON(data);
            }

        }

    });
}

function Quote(author, quote){
    this.author = author;
    this.quote = quote;
}
var quotes = [];
var quotes_index = 0;

function parseJSON(data){  
    

    var $author = $("#side_content").find("#author");
    var $quote = $("#main_content").find("#quote");
    
      

           
    $author.css({'opacity' : 0});
    $quote.css({'opacity' : 0});

    $author.text(data.author);
    $quote.text(data.content);

    quotes.push(new Quote(data.author, data.content));
    quotes_index++;



    $quote.stop(true,true);  
    $author.stop(false,false);
       
    $quote.animate({'opacity' : 1}, 1000);

    $.when($quote).done(function(){
        $author.animate({'opacity' : 1}, 1000);
    });
    
    
}

function plusSlides(num) {    

    if(quotes_index+num == 0){
        return;
    } else if(quotes_index+num > quotes.length){
        connectAPI();
    } else{
        var $author = $("#side_content").find("#author");
        var $quote = $("#main_content").find("#quote");

        quotes_index += num;
        $author.text(quotes[quotes_index-1].author);
        $quote.text(quotes[quotes_index-1].quote);
        
    }
  }