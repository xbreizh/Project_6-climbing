// Opens an autoclosing popup and redirects main page

function popupLogin() {
    window.open('login','popup','width=300,height=300,top=-800,left=800');
}
function popupLogout() {
    window.open('logout','popup','width=300,height=300,top=-800,left=800');
}
function toggle_visibility(id) {
    var e = document.getElementById(id);
    if(e.style.display == 'none')
        e.style.display = 'block';
    else
        e.style.display = 'none';
}
