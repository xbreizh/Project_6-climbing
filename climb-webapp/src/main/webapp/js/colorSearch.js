var text = document.getElementById("content");

var reg = new RegExp(word, "ig");
var str = text.innerHTML; //g is to replace all occurences

//fixing a bit
var toStr = String(reg);
var color = (toStr.replace('\/g', '|')).substring(1);

//split it baby
var colors = color.split("|");

if (colors.indexOf(word) > -1) {
    str = str.replace(reg, '<span style="color:red;">'+word+'</span>');
}


document.getElementById("content").innerHTML = str;

var toto
    function init( toto) {
        opener.location = toto;
        this.close();
    }
