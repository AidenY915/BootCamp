const imgTag = document.querySelector('#img')

const imgList = ['pic_1.jpg','pic_2.jpg','pic_3.jpg','pic_4.jpg','pic_5.jpg','pic_6.jpg','pic_7.jpg','pic_8.jpg','pic_9.jpg']

function changeImg(o) {
    let src=imgTag.src;
    let index = imgList.indexOf(src.slice(src.length-9));
    switch(o) {
        case -1:
            index--;
            index = index < 0 ? imgList.length-1 : index;
            break;
        case 1:
            index++;
            index = index >= imgList.length ? 0 : index;
            break;
    }
    src = 'images/'+imgList[index];
    imgTag.src = src;
}

