var canvas;

$(document).ready(function () {
    canvas = new fabric.Canvas('mainCanvas', {
        selection: false
    });


    fabric.Object.prototype.originX = fabric.Object.prototype.originY = 'center';

    if(window.innerWidth < 1024){        
        canvas.setWidth(window.innerWidth);
        canvas.setHeight(442.47)
    } else{
        canvas.setWidth(720);
        canvas.setHeight(480)
    }




    $(window).resize(function() {
        if(window.innerWidth >= 1024){
            canvas.setHeight(480);
            canvas.setWidth(720);

        } else{
            canvas.setHeight(442.47);
            canvas.setWidth(window.innerWidth);
        }
    });

    //moving circles and line together
    canvas.on('object:moving', function (e) {  

        const p = e.target;

        if(p.left < 0){    
            p.left = 0;
            
        }

        if(p.top < 0){
            p.top = 0;
            
        }

        if(p.left > canvas.width){
            p.left = canvas.width;

        }

        if(p.top > canvas.height){
            p.top = canvas.height;
        }


        if (p.line1.length > 0) {
            for (var i = 0; i < p.line1.length; i++) {
                p.line1[i].set({
                    'x1': p.left,
                    'y1': p.top
                });
            }

        }

        if (p.line2.length > 0) {
            for (var i = 0; i < p.line2.length; i++) {
                p.line2[i].set({
                    'x2': p.left,
                    'y2': p.top
                });
            }

        }
        canvas.renderAll();
    });   

    $("#how").change(function () {
        var state = $('#how option:selected').val();
        if (state == 'link') {
            $("#to").removeAttr('disabled', 'false');
        } else {
            $("#to").val('');
            $("#to").attr('disabled', true);
        }
    });

    $("#btnClear").click(function(){
        canvas.clear();
    });

    $("#btnExpand").click(function () {
        var idea = $("#idea").val().trim();
        var to = $("#to").val().trim();
        var how = $("#how").val();
    
    
        if (idea == "") {
            return;
        } else if (how == "add" && findShape(canvas, idea, fabric.Groups) == null) {
            drawCircle(canvas, idea, 50);
    
        } else if (how == "remove") {
            removeObject(canvas, idea);
    
        } else if (how == "link") {
            if(to == "") return;

            const shapes = [findShape(canvas, to, fabric.Groups), findShape(canvas, idea, fabric.Groups)];
            if (shapes[0] == null) {
                shapes[0] = drawCircle(canvas, to, 50);
            }
            if (shapes[1] == null) {
                shapes[1] = drawCircle(canvas, idea, 50);
            }
    
            linkCircles(canvas, shapes[0], shapes[1]);
    
        }

        $("#idea").val("");
        $("#to").val("");

    });

});


function onlyAlphabet(ele){
    ele.value = ele.value.replace(/[^\\!-z]/gi, "");
}





//make a circle with text
function makeCircle(text, radius) {

    const x = Math.random() * canvas.width;
    const y = Math.random() * canvas.height;

    const c = new fabric.Circle({
        strokeWidth: 1,
        radius: radius,
        fill: 'white',
        stroke: '#232941',
        selectable: false,
        evented: false,
    });

    const t = new fabric.Text(text, {
        fontSize: 20,
        fill: '#295651'
    });

    const circle = new fabric.Group([c, t], {
        name: text,
        left: x,
        top: y,
        line1: [],
        line2: []

    });
    circle.hasControls = circle.hasBorders = false;

    return circle;
} // end makeCircle(text, radius)

function drawCircle(canvas, text, radius) {
    const circle = makeCircle(text, radius);

    canvas.add(circle);
    return circle;
} // end drawCircle(canvas, text, radius)

//make line from shape1 to shape2
function makeLine(shape1, shape2) {

    const line = new fabric.Line([shape1.left, shape1.top, shape2.left, shape2.top], {
        //fill: 'black',
        stroke: '#232941',
        strokeWidth: 1,
        selectable: false,
        evented: false,
    });

    return line;
} //end makeLine(shape1, shape2)

function linkCircles(canvas, circle1, circle2) {


    const line = makeLine(circle1, circle2);
    line.name1 = circle1.name + circle2.name;
    line.name2 = circle2.name + circle1.name;
    canvas.add(line);
    canvas.sendToBack(line);
    circle1.line1.push(line);
    circle2.line2.push(line);



} //end drawDoubleCircles(canvas, cirName1, cirName2, radius)

//remove Circle and its line together
function removeObject(canvas, name) {
    const gList = canvas.getObjects(fabric.Groups);
    gList.forEach(function (element) {
        if (element.name == name) {
            for (var i = 0; i < element.line1.length; i++) {
                canvas.remove(element.line1[i]);
            }
            for (var i = 0; i < element.line2.length; i++) {
                canvas.remove(element.line2[i]);
            }
            canvas.remove(element);
        }
    });

}

// find a shape by name and type(fabric.Groups, fabric.Lines)
function findShape(canvas, name, type) {
    const list = canvas.getObjects(type);
    let shape = null;
    list.forEach(function (e) {
        if (e.name == name) {
            shape = e;
        }
    });
    return shape;
} //end findCircle(canvas, name)