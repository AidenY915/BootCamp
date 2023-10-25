class Rectangle {
  constructor(private base: number, private height: number) {}
  getPerimeter() {
    return (this.base + this.height) * 2;
  }
  getArea() {
    return this.base * this.height;
  }
}
class Square extends Rectangle {
  constructor(base: number) {
    super(base, base);
  }
}

let rect = new Rectangle(10, 20);
let square = new Square(10);
console.log(rect.getPerimeter(), rect.getArea());
console.log(square.getPerimeter(), square.getArea());
