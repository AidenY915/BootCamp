var Student = /** @class */ (function () {
    function Student(name, kor, eng, math, sci) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.sci = sci;
    }
    Student.prototype.getSum = function () {
        return this.kor + this.eng + this.math + this.sci;
    };
    Student.prototype.getAverage = function () {
        return this.getSum() / 4;
    };
    Student.prototype.toString = function () {
        return "".concat(this.name, "\t").concat(this.getSum(), "\t").concat(this.getAverage(), "\n");
    };
    return Student;
}());
var students = [];
students.push(new Student("구름", 87, 98, 88, 90));
students.push(new Student("ts별이", 92, 98, 96, 88));
students.push(new Student("겨울", 76, 96, 94, 86));
students.push(new Student("바다", 98, 52, 98, 92));
console.log(students);
var output = "이름\t총점\t평균\n";
for (var _i = 0, students_1 = students; _i < students_1.length; _i++) {
    var s = students_1[_i];
    output += s.toString();
}
console.log(output);
