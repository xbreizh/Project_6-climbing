// Opens an autoclosing popup and redirects main page

function popupLogin() {
    window.open('login','popup','width=300,height=300,top=-800,left=800');
}
function popupLogout() {
    window.open('logout','popup','width=300,height=300,top=-800,left=800');
}
function toggle_visibility(id) {
    var e = document.getElementById(id);
    if(e.style.visibility == 'hidden')
        e.style.visibility = 'visible';

    else
        e.style.visibility = 'hidden';
}

function resizeElement(){
    var element1 = document.getElementById('skra');
    var element2 = document.getElementById('index_result');
    console.log(element1.classList);

    if(element1.classList.contains('col-lg-12')){
        element1.classList.remove("col-lg-12");
        element1.classList.remove("col-md-12");
        /*toggle_visibility('index_result');*/
        element1.classList.toggle("col-lg-6");
        element1.classList.toggle("col-md-6");
        element2.classList.remove("hidden");
    }else{
       /* toggle_visibility('index_result');*/
        element1.classList.remove("col-lg-6");
        element1.classList.remove("col-md-6");
        element1.classList.toggle("col-lg-12");
        element1.classList.toggle("col-md-12");
        element2.classList.toggle("hidden");
    }





}