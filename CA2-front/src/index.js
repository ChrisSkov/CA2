import 'bootstrap/dist/css/bootstrap.css'

window.onload = (event) => {
    var url = "https://goinghamdev.com/CA2/api/allPersonsHobby/Hobby";
    fetch(url)
        .then(res => res.json())
        .then(data => {
            document.getElementById("getHobby").innerHTML = toSelect(data);
        })

        var url2 = "https://goinghamdev.com/CA2/api/allZips";
    fetch(url2)
        .then(res => res.json())
        .then(data => {
            document.getElementById("getZip").innerHTML = toSelectZip(data);
        })
};



