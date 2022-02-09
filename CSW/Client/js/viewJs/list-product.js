var domain = "http://localhost:8081/api/product";

$(document).ready(function(){
  getList();
 
})



// get list seminar
function getList() {
  $.ajax({
    type: "GET",
    url: domain + "/list",
    contentType: "application/json; charset=utf-8",
		datatype:"json",
    async: false,
    success: function (response) {
      console.log(response);
        //showSeminar(seminar);    
    },
  });


}

//show product
function showProduct(product) {

  $("#list-seminar tbody").append(
    "<tr>" +
      "<td>" +
      product.name +
      "</td>" +
      "<td>" +
      product.price +
      "</td>" +
      "<td>" +
      product.quantity +
      "</td>" +
    "</tr>"
  );

}