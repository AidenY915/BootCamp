const onclickButton = () =>{
    alert("버튼 눌림");
}

const printContent = (id) =>{
    console.log(document.querySelector('#'+id+'>p:first-child'));
    console.log(document.querySelector('#'+id+'>p:last-child'));
}

const night = ()=>{
    const style = document.querySelector('body').style;
    style.backgroundColor = style.backgroundColor=='black' ? 'white' : "black" ;
    style.color = style.backgroundColor=='black' ? 'white' : "black" ;
}

const getRandom = (formId,button) =>{
    event.preventDefault();
    const a = Number(document.querySelector("#"+formId+">input:first-child").value);
    const b = Number(document.querySelector("#"+formId+">input:nth-child(2)").value);
    const result = Math.floor(Math.random()*(b-a+1))+a;
    button.innerHTML = result;

}

const fruits = ["Banana", "Orange", "Apple", "Mango"];
fruits.sort();
console.log(fruits);
fruits.reverse();
console.log(fruits);

const points = [40, 100, 1, 5, 25, 10];
points.sort(()=>{return 0.5-Math.random();})
console.log(points);

const cars = [
    {type:"Volvo", year:2016},
    {type:"Saab", year:2001},
    {type:"BMW", year:2010}
  ];
cars.sort((a,b)=>{return a.year-b.year;});
console.log(cars);
cars.sort((a,b)=>{return a.type.toUpperCase()>=b.type.toUpperCase() ? 1 : -1;});
console.log(cars);