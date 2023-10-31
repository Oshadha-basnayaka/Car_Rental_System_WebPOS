// let baseUrl : string = "http://localhost:8080/backEnd_war/";



$("#btnSubmit").click(function () {
    var formData  = new FormData($("#customerform")[0]);
    $.ajax({
        url: 'http://localhost:8080/carRental/customer',
        method:"Post",
        type:"POST",
        async:true,
        contentType:false,
        processData:false,
        data:formData,
        success: function (res)  {
            alert(res.message);
        },
        error:function (err){
            // let errMessage = JSON.parse(err.responseText);
            alert(err.message)
        }

    });
});