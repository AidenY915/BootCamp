class Square {
  #length;
  static #counter = 0;
  constructor(length) {
    this.length = length;
    Square.#counter += 1;
  }
  set length(length) {
    if (length < 0) throw new Error("이상 길이");
    this.#length = length;
  }
  get length() {
    return this.#length;
  }
  static get counter() {
    return Square.#counter;
  }
}

let sq1 = new Square(1);
let sq2 = new Square(1);
let sq3 = new Square(1);
console.log(Square.counter);
