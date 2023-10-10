const board = [0,1,2,3,4,5,6,7,8];
let indexOf0 = 0;
const numOfCol = Math.sqrt(board.length);
const paintBoard = () => {
    for(let i = 0; i < board.length; i++) {
        let button = document.getElementById('b'+ i);
        button.innerText = board[i];
    }
    const button0 = document.getElementById('b'+ indexOf0);
    button0.style.backgroundColor='white';
    button0.style.color='white';
}

const swap = (board, i ,j) => {
    let tmp = board[i];
    board[i] = board[j];
    board[j] = tmp;
}

const shuffleBoard = () => {
    for(let i = board.length-1; i > 0; i--){
        let j = Math.floor(Math.random()*(i+1));
        swap(board,i,j);
        if(board[i] == 0) indexOf0 = i;
    }
}

const initGame = () => {
    shuffleBoard();
    paintBoard();
}

const buttonClicked = (id) => {
    const i = Number(id.slice(1));
    if(i+numOfCol == indexOf0 || i-numOfCol == indexOf0 || (i+1 == indexOf0 &&  i%numOfCol != numOfCol-1) || (i-1 == indexOf0 &&  i%numOfCol != 0)){
        swap(board,i,indexOf0);
        const buttoni = document.getElementById('b'+ i);
        const button0 = document.getElementById('b'+ indexOf0);
        buttoni.innerText=board[i];
        button0.innerText=board[indexOf0];
        buttoni.style.backgroundColor='white';
        buttoni.style.color='white';
        button0.style.backgroundColor='cornsilk';
        button0.style.color='black';
        indexOf0=i;
    }
}

initGame();