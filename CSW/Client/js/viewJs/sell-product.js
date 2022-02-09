var domain = "http://localhost:8081";
const regexDateTime = /(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})/;


$(document).ready(function () {
  



  function validateForm() {
    var flag = true;
    if ($("#productId").val().trim() == "") {
      flag = false;
      $("#productId-valid").text("Product Name can not be empty");
    } else {
      $("#productId-valid").text("");
    }
    if ($("#quantity").val() == "") {
      flag = false;
      $("#quantity-valid").text("Quantity can not be empty");
    } else {
      $("#quantity-valid").text("");
    }

    return flag;
  }
  $("#submit").click(function () {
    var check = validateForm();
    if (check) {
        var id=$("#productId").val(),
        var quantity =$("#quantity").val()

      $.ajax({
        type: "POST",
        url: domain + "/api/product/sell?productId="+id+"&quantity="+quantity,
        dataType: "json",
        async: true,
        success: function (response) {
          window.location.replace("list-product.html");
        },
        error: function (response) {
          const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
              confirmButton: "btn btn-success",
              cancelButton: "btn btn-danger mr-3",
            },
            buttonsStyling: false,
          });
          swalWithBootstrapButtons.fire(
            "Create Failed",
            "Something went wrong please try again",
            "error"
          );
        },
      });
    }
  });
});

function loadSubject(){
  $.ajax({
    type: "GET",
    url: domain + "/api/Subject",
    headers: {
      Authorization: "Bearer " + token,
    },
    async: true,
    success: function (response) {
      response.forEach(function(subject) {
        $('#SubjectId').append(`<option value="${subject.Id}">
                                       ${subject.Subject}
                                  </option>`);
      });
    },
  });
}