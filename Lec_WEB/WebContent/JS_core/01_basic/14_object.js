console.log('object');

//property:value 쌍
x = {firstName: "john", lastName: "Doe"};
console.log(x, typeof x);
console.log(x['firstName'], x.firstName);
// console.log(x[firstName]);

//object는 length값 없다
console.log(x.length);

//for~in
for(key in x){ //property가 추출됨.(string)
    console.log(`x[${key}] = ${x[key]}`);
}

//value는 어떠한 타입이라도 가능!
x = {
    name : "kim"
};

console.log(x['name']);

x = {
    name : "kim"
    , age : 34
    , height : 172.3
    , score : [94, 35, 79]
    , sayHello : function(){
        console.log('안냐세요');
    }
    , getScore : function(n){
        return this.score[n]; //this빼면 에러
    }
    , getTotal : function(){
        var total = 0;
        for(i=0; i < this.score.length; i++){
            total += this.score[i];
        }
        return total;
    }
    ,getAvg : function(){
        var avg = this.getTotal() / this.score.length;
        return avg.toFixed(2); //소숫점 2자리까지.
    }
}

console.log(x['name'], typeof x["name"]);
console.log(x['age'], typeof x["age"]);
console.log(x['height'], typeof x["height"]);
console.log(x.score, x.score.length);
x.sayHello();
console.log(x.getScore(0));
console.log(x.getTotal());
console.log(x.getAvg());
console.log(x['getAvg']());

console.log();

x = {firstName: "John", lastName: "Doe"};
console.log(x);
x.firstName = "Mike" //변경
console.log(x);

x['age'] = 45; //없던 property추가
console.log(x);

delete x.firstName;
console.log(x);

console.log(x.firstName);

// console.log(a);에러
var b;
console.log(b);
b = "김재현";
console.log(b);

//'함수'가 'object 생성자'로 사용가능
function Person(firstName, lastName, age){
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;

    // console.log(this);
}

Person('aaa', 'bbb', 30);

var p1 = new Person('aa', 'bbb', 30); //생성자
console.log(p1);
var p2 = new Person('김', '재현', 25);
console.log(p2);