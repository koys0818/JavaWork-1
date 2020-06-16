$(document).ready(function() {
	// 게시판 목록 1페이지 로딩
	loadPage();
});

function loadPage() {

	$.ajax({
		url : "cate.list.ajax",
		type : "POST",
		cache : false,
		success : function(data, status) {
			if (status == "success") {

				if (updateList(data)) {
					selectViewEvent();
				}
			}
		}
	});
} // end loadPage()

function updateList(jsonObj) {
	result = "";

	if (jsonObj.status == "OK") {

		var count = jsonObj.count;

		var i;
		var items = jsonObj.data; // 배열
		for (i = 0; i < count; i++) {

			result += "<option id='op' value='" + items[i].uid + "'>";
			result += items[i].name;
			result += "</option>";
		} // end for

		$("#depth1").removeAttr('disabled'); // 셀렉트 선택가능!
		$("#depth1").html(result); // 셀렉트 업데이트!

		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
} // end updateList()

function updateList2(jsonObj) {
	result = "";

	if (jsonObj.status == "OK") {

		var count = jsonObj.count;

		var i;
		var items = jsonObj.data; // 배열
		for (i = 0; i < count; i++) {

			result += "<option id='op' value='" + items[i].uid + "'>";
			result += items[i].name;
			result += "</option>";
		} // end for

		$("#depth2").removeAttr('disabled'); // 셀렉트 선택가능!
		$("#depth2").html(result); // 셀렉트 업데이트!

		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
} // end updateList()

function updateList3(jsonObj) {
	result = "";

	if (jsonObj.status == "OK") {

		var count = jsonObj.count;

		var i;
		var items = jsonObj.data; // 배열
		for (i = 0; i < count; i++) {

			result += "<option id='op' value='" + items[i].uid + "'>";
			result += items[i].name;
			result += "</option>";
		} // end for

		$("#depth3").removeAttr('disabled'); // 셀렉트 선택가능!
		$("#depth3").html(result); // 셀렉트 업데이트!

		return true;
	} else {
		alert(jsonObj.message);
		return false;
	}
	return false;
} // end updateList()

function selectViewEvent() {

	$("#depth1").change(function() {

		// 읽어오기
		$.ajax({
			url : "cate.list.ajax?parent=" + $(this).val() + "&depth=2",
			type : "POST",
			cache : false,
			success : function(data, status) {
				if (status == "success") {
					if (data.status == "OK") {

						if (updateList2(data)) {
							selectViewEvent2();
						}

					} else {
					}
				}
			}
		});

	});

} // end addViewEvent()
function selectViewEvent2() {

	$("#depth2").change(function() {

		// 읽어오기
		$.ajax({
			url : "cate.list.ajax?parent=" + $(this).val() + "&depth=3",
			type : "POST",
			cache : false,
			success : function(data, status) {
				if (status == "success") {
					if (data.status == "OK") {

						updateList3(data);

					} else {
					}
				}
			}
		});

	});

} // end addViewEvent()
