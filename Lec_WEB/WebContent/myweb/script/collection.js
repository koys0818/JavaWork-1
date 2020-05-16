/* <Unsplash API를 이용하여 사진을 가져오기 */
//  1시간에 50회 제한!!!    

var jsonData;

$(document).ready(function () {
    var api_key = "NFp6H9odsFWwgJLtL6yifEy8wNOcVOhsmIVCqrsR9Lw";
    var page_num = parseInt(Math.random() * 20) + 1;

    $.ajax({
        url: "https://api.unsplash.com/collections/featured?page=" + page_num + "&per_page=30&client_id=" + api_key,
        type: "GET",
        cache: false,
        success: function (data, status) {
            if (status == "success") {
                jsonData = data;
                parseJSON(jsonData, 0);
            }

        }

    });

    // $("a.next").click(function(){
    //     parseJSON(jsonData);
    // });
});

var photo_index = 0;

function parseJSON(jsonData, num) {

    if((photo_index + num) < 0 || (photo_index + num > 29)) return;
    photo_index += num;

    var img_url = jsonData[photo_index].cover_photo.urls.small;
    var img_url = jsonData[photo_index].preview_photos[0].urls.small;
    var img_title = jsonData[photo_index].title;
    var img_dcription = jsonData[photo_index].description;
    var img_link = jsonData[photo_index].links.html;

    $("#main_img").attr('src', img_url);
    $("#img_title").text(img_title);
    $("#img_dcription").text(img_dcription);      
    $('#loading').hide();
       
}

function plusSlides(num) {
    parseJSON(jsonData, num);
  }

