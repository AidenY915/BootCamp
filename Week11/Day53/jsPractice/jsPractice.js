
document.getElementById("div1").innerHTML = "<b>야</b>";

demoButtonOnclick = () => {
    let button = document.getElementById("demoButton")
    button.innerHTML = "Hello JavaScript";
}

turn = (o) => {
    let img;
    switch(o){
        case 0: img = "pic_bulboff.gif"; break;
        case 1: img = "pic_bulbon.gif";
    }
    document.getElementById("bulb").src=img;
}

let string = "";
for(let i = 0; i<=4; i++){
    string += "<tr>"
    for(let j = 1; j<=5; j++){
        string += `<td>${i*5+j}</td>`;
    }
    string += "</tr>"
}
document.getElementById("table").innerHTML= string;

document.getElementById("table").style.border = "1px solid black";

console.log(Document);