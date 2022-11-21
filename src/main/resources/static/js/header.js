
const header = document.querySelector("#header")
const sidebar = document.querySelector("#sidebar");
const headerHeight = header.offsetHeight;

window.addEventListener('onload',function (){
    alert("asdasdasd");
    sidebar.style.position="sticky";
    sidebar.style.top=headerHeight+"px";
    sidebar.style.alignSelf="baseline";
})
