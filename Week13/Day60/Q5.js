function max1(array) {
  let maxValue = -Infinity;
  for (let i = 0; i < array.length; i++) {
    maxValue = maxValue < array[i] ? array[i] : maxValue;
  }
  return maxValue;
}

function max2(...args) {
  let maxValue = -Infinity;
  for (let i = 0; i < args.length; i++) {
    maxValue = maxValue < args[i] ? args[i] : maxValue;
  }
  return maxValue;
}

function max3(...args) {
  let arr = [];
  for (let i = 0; i < args.length; i++) {
    if (Array.isArray(args[i])) arr.push(...args[i]);
    else arr.push(args[i]);
  }
  let maxValue = -Infinity;
  for (let i = 0; i < arr.length; i++) {
    maxValue = maxValue < arr[i] ? arr[i] : maxValue;
  }
  console.log(arr);
  return maxValue;
}

const nums = [1, 2, 3, 4];
console.log(max1(nums));
console.log(max2(...nums));
console.log(max3(nums, nums));
console.log(max3(...nums));

const f1 = () => {
  return "Hi";
};
console.log(f1());
const f2 = (a, b) => {
  return a + b;
};
console.log(f2(3, 4));
const f3 = (start, end) => {
  str = "";
  for (let i = start; i <= end; i++) {
    str += i;
  }
  console.log(str);
};
f3(1, 10);
const arr = [1, 2, 3];
console.log(
  arr.map((e) => {
    return e * 2;
  })
);

console.log(
  arr.map(function (e) {
    return e * 2;
  })
);
