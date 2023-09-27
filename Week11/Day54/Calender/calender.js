const table = document.getElementById("calender");

const today = new Date();
const year = today.getFullYear();
const month = today.getMonth();
const date = new Date(year, month, 1);
table.innerHTML=`<div>${date}</div><table id = "calenderMain" ><tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr></table>`;

let numOfDays;
switch(month){
    case 1: case3: case5: case7: case8: case10: case12:
        numOfDays=31; break;
    default : numOfDays=30;
}

const main = document.getElementById("calenderMain");

day = date.getDay();



let weeks = day + numOfDays/7 + ((day+numOfDays)%7==0 ? 0 : 1);
let j = 1;
for(let i = 0 ;i < weeks;i++){   
    main.innerHTML+=`<tr id = 'week${i}'></tr>`
    for(let k = 0 ;k < 7;k++){
        if(j-day>numOfDays){
            document.getElementById(`week${i}`).innerHTML+="<td></td>";
        }
        else {
            
            if(today.getDate()  == j - day) {
                document.getElementById(`week${i}`).innerHTML+=`<td>${(j>day ? j-day : ' ')+"<br/>"+today.getHours()+":"+today.getMinutes()}</td>`    
            }
            else
                document.getElementById(`week${i}`).innerHTML+=`<td>${j>day ? j-day : ' '}</td>`
        }
        j++;
    }
    if(j-day>numOfDays) break;
} 