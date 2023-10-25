class Rectangle {
  constructor(private base: number, private height: number) {
    if (base < 0 || height < 0) throw new Error("길이는 양수이어야 함.");
  }
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
let rect;
let square;
try {
  rect = new Rectangle(-10, 20);
  square = new Square(-10);
  console.log(rect.getPerimeter(), rect.getArea());
  console.log(square.getPerimeter(), square.getArea());
} catch (e) {
  console.log(e);
}
