const imgList = ['pic_1.jpg', 'pic_2.jpg', 'pic_3.jpg', 'pic_4.jpg', 'pic_5.jpg', 'pic_6.jpg', 'pic_7.jpg', 'pic_8.jpg', 'pic_9.jpg'];
const imgPath = 'images'
let currImgIndex = 0;
const changeImg = (o) => {
    img = document.querySelector('img');
    console.log(img.src);
    switch(o) {
        case -1 :
            currImgIndex--;
            if(currImgIndex <= 0) currImgIndex = imgList.length-1;
            img.src = imgPath + '/' + imgList[currImgIndex];
            break;
        case 1 :
            currImgIndex++;
            if(currImgIndex >= imgList.length) currImgIndex = 0;
            img.src = imgPath + '/' + imgList[currImgIndex];
            break;
    }
}