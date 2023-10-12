//1
function print(i) {
  console.log(`${i}번째 함수 호출`);
}

(function (start, end, callback) {
  for (let i = start; i <= end; i++) callback(i);
})(0, 2, print);

//2
const numbers = [273, 52, 103, 32, 57];
numbers.forEach((e, i) => {
  console.log(i + "번째 요소 : " + e);
});

//3
console.log(numbers.map((e) => e * e));

//4
const numbers1 = [0, 1, 2, 3, 4, 5];
console.log(numbers1.filter((e) => (e % 2) - 1));

//5
const numbers2 = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
console.log(numbers2.filter((e) => (e % 2) - 1).map((e) => e * e));

//6
setTimeout(() => {
  console.log("1초 후 실행");
}, 1000);

//7
let cnt = 0;
let intervalId = setInterval(() => {
  console.log(++cnt + "초");
}, 1000);

setTimeout(() => {
  console.log("5초 후 종료");
  clearInterval(intervalId);
}, 5100);

const array = ["사과", "배", "귤", "바나나"];

console.log("# for in 반복문");
array.forEach((e, i) => console.log(i));

console.log("# for of 반복문");
array.forEach((e) => console.log(e));
