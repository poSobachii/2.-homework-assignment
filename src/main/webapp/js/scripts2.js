
function testJS() {
     alert("JS loaded")
        };

function printBasket(){
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:8080/responses/printBasketOrder.jsp", true);
  http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  http.send("param1=null");
  http.onload = function(){
  alert("check console");
  }
};

 function add_to_basket(type, name, id){
  var http = new XMLHttpRequest();
  http.open("POST", "http://localhost:8080/responses/addBasketResponse.jsp", true);
  http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  http.send("param1=" + type + "&param2=" + name + "&param3=" + id);
  http.onload = function() {
  alert(http.responseText);
  }
  };




