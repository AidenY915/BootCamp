class Square {
  #length;
  static #counter = 0;
  constructor(length) {
    if (length < 0) throw new Error("길이는 양수여야 합니다.");
    this.#length = length;
    Square.#counter++;
  }
  get length() {
    return this.#length;
  }
  set length(length) {
    this.#length = length;
  }
  getPerimeter() {
    return this.#length * 4;
  }
  getArea() {
    return this.#length ** 2;
  }
  /** @Override */
  toString() {
    return "" + this.#length + this.getPerimeter() + this.getArea();
  }
}

let squ = new Square(20);
console.log(squ.length, squ.getPerimeter());
squ.length = 30;
console.log(squ.length, squ.getArea());
console.log(String(squ));
