alert("JSSSSSSSSSSSSSSS loaded");

function myFunction() {
 document.getElementById("demo").innerHTML = "Hello World";
                 }

        <p id="demo"></p>


function take_values(){
    var n=document.forms["myform23"]["dogsss"].value;
    out.println(n);
    if (n==null || n=="") {
    alert("Please enter User Name");
    return false;
    }else{
    var http = new XMLHttpRequest();
    http.open("POST", "http://localhost:8080/submitform.jsp", true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    var params = "param1=" + n;
    http.send(params);
    http.onload = function() {
    alert(http.responseText);
 }
 }
 }

 function add_to_basket(){
  var n=document.forms["addToBasket"]["basketValue"].value;
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:8080/submitform.jsp", true);
  http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  var params = "param1=" + n;
  http.send(params);
  http.onload = function() {
  alert(http.responseText);
  }
  }


  function add_to_basket2(tempo1, tempo2){
     var http = new XMLHttpRequest();
     alert("vars are:" + tempo1 + "," + tempo2);
     http.open("POST", "http://localhost:8080/addBasketResponse.jsp", true);
     http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
     var params = ("param1=" + tempo1 + "&param2=" + tempo2);
     http.send(params);
     http.onload = function() {
     alert(http.responseText);
     }
     };