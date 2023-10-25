class Student {
  constructor(name, kor, eng, math, sci) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sci = sci;
  }
  getSum() {
    return this.kor + this.eng + this.math + this.sci;
  }
  getAverage() {
    return this.getSum() / 4;
  }
  toString() {
    return `${this.name}\t${this.getSum()}\t${this.getAverage()}\n`;
  }
}

const students = [];
students.push(new Student("구름", 87, 98, 88, 90));
students.push(new Student("별이", 92, 98, 96, 88));
students.push(new Student("겨울", 76, 96, 94, 86));
students.push(new Student("바다", 98, 52, 98, 92));

console.log(students);

let output = "이름\t총점\t평균\n";
for (const s of students) {
  output += s.toString();
}
console.log(output);
