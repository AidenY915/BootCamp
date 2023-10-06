let fruits = ["Banana", "Orange", "Apple", "Mango"];
console.log(fruits.join('*'));

console.log(fruits.pop());
console.log(fruits.shift());
fruits.unshift("Lemon");
console.log(fruits.length);
fruits[fruits.length]="kiwi"
console.log(fruits);
delete fruits[0];
console.log(fruits);
fruits.shift();
console.log(fruits);

const a = [1,2,3,4];
const b = [5,6,7,8];
let c = [...a,...b];
console.log(c);

c = a.concat(b);
console.log(c);

c= a.concat(b,a);
console.log(c);

const arr1 = ["Emil", "Tobias", "Linus"];
arr1.push("peter");
console.log(arr1);

fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.splice(2,0,"Lemon","Kiwi");
console.log(fruits);

fruits.splice(2,4,"Lemon","Kiwi");
console.log(fruits);

fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.splice(fruits.indexOf("Apple"),1);
console.log(fruits);

fruits = ["Banana", "Orange", "Lemon", "Apple", "Mango"];
console.log(fruits.slice(1,3));

fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.sort();
console.log(fruits);
fruits.reverse();
console.log(fruits);

const points = [40, 100, 1, 5, 25, 10];
points.sort();
console.log(points);
points.reverse();
console.log(points);
points.sort(()=>{return Math.random() - 0.5;});
console.log(points);
console.log(Math.max(...points));
console.log(Math.min(...points));

let numbers = [45, 4, 9, 16, 25];
console.log(numbers.toString());
console.log(numbers.map((e)=>{return e*2;}))
console.log(numbers.filter((e)=>{return e>=18}));
console.log(numbers.reduce((sum,e)=>{return sum+e}));
console.log(numbers.reduce((sum,e)=>{return sum+e},100));
console.log(numbers.reduceRight((sum,e)=>{return sum+e}));
console.log(numbers.every((e)=>{return e}));
console.log(numbers.some((e)=>{return e>18}));

fruits = ["Apple", "Orange", "Apple", "Mango"];
console.log(fruits.includes("Apple"));
console.log(fruits.indexOf("Apple"));

numbers = [4, 9, 16, 25, 29];
console.log(numbers.find((e)=>{return e > 18}));
console.log(numbers.findIndex((e)=>{return e > 18}));

let arr = new Array(..."ABCDEFG");
console.log(arr);

fruits = ["Banana", "Orange", "Apple", "Mango"];
const itr = fruits.keys()


