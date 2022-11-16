const sidebar = document.querySelector("#sidebar");
const headerHeight = header.offsetHeight;

window.addEventListener('onload',function (){
    sidebar.style.position="sticky";
    sidebar.style.top=headerHeight+"px";
    sidebar.style.alignSelf="baseline";
})
