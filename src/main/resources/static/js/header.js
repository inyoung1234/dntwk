window.onload = function () {
    const header = document.querySelector("#header");
    const sidebar = document.querySelector("#sidebar");
    const headerHeight = header.offsetHeight;

    sidebar.style.position = "sticky";
    sidebar.style.top = headerHeight + "px";
    sidebar.style.alignSelf = "baseline";
}