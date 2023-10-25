const createStudent = function (name, kor, eng, math, sci) {
  return {
    name: name,
    kor: kor,
    eng: eng,
    math: math,
    sci: sci,
    getSum() {
      return this.kor + this.eng + this.math + this.sci;
    },
    getAverage() {
      return this.getSum() / 4;
    },
    toString() {
      return `${this.name}\t${this.getSum()}\t${this.getAverage()}\n`;
    },
  };
};

const students = [];
students.push(createStudent("구름", 87, 98, 88, 90));
students.push(createStudent("별이", 92, 98, 96, 88));
students.push(createStudent("겨울", 76, 96, 94, 86));
students.push(createStudent("바다", 98, 52, 98, 92));

// 출력합니다.
let output = "이름\t총점\t평균\n";
for (const s of students) {
  output += s.toString();
}
console.log(output);
