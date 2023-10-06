const nums = [[0,1,2],[3,4,5],[6,7,8]]
let i0, j0;

function paintBoard() {
    const table = document.querySelector("#buttonGame>table")
    let innerString = "";
    for(let i = 0 ; i < 3; i++){
        innerString += '<tr>';
        for(let j = 0 ; j < 3; j++){
            innerString+=`<td><button id = "${i}${j}" onclick = 'buttonClick(${i},${j})'>${nums[i][j] == 0 ? "" : nums[i][j]}</button></td>`;
        }
        innerString += '</tr>';
    }
    table.innerHTML=innerString;
}

function initializeGame(){
    for(let i = 8; i > 0 ; i--){
        let j = Math.floor((Math.random()*(i+1)));
        let tmp = nums[Math.floor(i/3)][i%3];
        nums[Math.floor(i/3)][i%3] = nums[Math.floor(j/3)][j%3];
        nums[Math.floor(j/3)][j%3] = tmp;
    }
    paintBoard();
}

const modifyPart = (i,j,x,y) => {
    const pos0 = document.getElementById(""+i+j);
    const posX = document.getElementById(""+x+y);
    innerString0=nums[i][j];
    innerStringX="";
    pos0.innerHTML = innerString0;
    posX.innerHTML = innerStringX;
}

function buttonClick(x,y) {
    if((Math.abs(x-i0) == 1 && y == j0 )||(Math.abs(y-j0) == 1 && x == i0 ))
    {
        const tmp = nums[x][y];
        nums[x][y] = 0;
        nums[i0][j0] = tmp;
        modifyPart(i0,j0,x,y)
        i0=x;
        j0=y;
        
    }
    else return;
}

initializeGame();

find0:
for(i0=0; i0 < 3; i0++){
    for(j0=0; j0 < 3; j0++){
        if(nums[i0][j0] == 0){ 
            break find0;
        }
    }
}
