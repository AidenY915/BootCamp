const calenderBody = document.getElementById("calenderBody")

let today = new Date();
let todayYear = today.getFullYear();
let todayMonth = today.getMonth();
let todayDate = today.getDate();


const lastDateOfMonth = [31,28,31,30,31,30,31,31,30,31,30,31];

let displayedYear = todayYear;
let displayedMonth = todayMonth;

const scheduleMap = new Map();


function repaintCalender(){
    let startDay = new Date(displayedYear,displayedMonth,1).getDay();
    let lastDate = lastDateOfMonth[displayedMonth];
    if((displayedYear % 400 == 0 || (displayedYear % 4 == 0 && displayedYear % 100 != 0 )) && displayedMonth==1)
        lastDate++;
    let dateCnt = 1;
    let cell = 0;
    let calenderBodyString="";

    document.getElementById("caption").innerHTML=`${displayedYear+"년 "+(displayedMonth+1)+"월"}`

    while(dateCnt<=lastDate){
        calenderBodyString+="<tr>";            
        for(let i = 0 ; i < 7; i++){
            if(cell < startDay || dateCnt > lastDate){
                calenderBodyString+="<td></td>";            
            }
            else{
                let dateId = displayedYear+''+displayedMonth+''+dateCnt;
                let schedule = scheduleMap.get(dateId);
                schedule = (schedule == undefined || schedule == null) ? "" : schedule;
                calenderBodyString+=`<td id='${dateId}' class="dateCell"><button class='scheduleSetButton' onclick="setSchedule('${dateId}' )"><span>${dateCnt}</span><div>${schedule}</div></button></td>`;
                dateCnt++;
            }
            cell++;
        }
        calenderBodyString+="</tr>";            
    }
    calenderBody.innerHTML='<tr><th>일</th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th><th>토</th></tr>'+calenderBodyString;
    
}

function changeMonth(direction){
    switch (direction){
        case -1 :
        displayedMonth--;
        if(displayedMonth<0) {
            displayedMonth = 12;
            displayedYear--;
        }
        break;
        case 1 :
        displayedMonth++;
        if(displayedMonth>11) {
            displayedMonth = 0;
            displayedYear++;
        }
    }
    repaintCalender();
}
function setSchedule(dateId){
    let existing = scheduleMap.get(dateId);
    existing = (existing == undefined || existing == null) ? "" : existing;
    let newSchedule = prompt();
    if(newSchedule == '' || newSchedule == null)
        scheduleMap.set(dateId,null);    
    else
        scheduleMap.set(dateId,existing+'<br>'+newSchedule);
    console.log(scheduleMap);
    repaintCalender();
}

repaintCalender();

