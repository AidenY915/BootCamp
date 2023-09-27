const divQ5 = document.getElementById("q5");
let string="<table>";
for(let i = 0 ; i < 25; i++){
    if(i%5==0)
    {
        string+="<tr>";
    }
    string+=`<td>${i+1}</td>`;
    if(i%5==4)
    {
        string+="</tr>";
    }
}
string+="</table>";
divQ5.innerHTML=string;

const changeStyle = (id,value) => {
    style = document.getElementById(id).style;
    style.backgroundColor = "yellow";
    style.fontSize = "25px";
    style.color = "red";
}

function switchBulb(id) {
    bulbImg = document.getElementById(id);
    switch(bulbImg.src){
        case "http://127.0.0.1:5500/Day54/morningTest/pic_bulboff.gif": bulbImg.src = "pic_bulbon.gif"; break;
        case "http://127.0.0.1:5500/Day54/morningTest/pic_bulbon.gif": bulbImg.src = "pic_bulboff.gif";
    }
} 


