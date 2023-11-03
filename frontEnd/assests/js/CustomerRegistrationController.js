// let baseUrl : string = "http://localhost:8080/backEnd_war/";
getAllCustomer();

//get all customer event
$("#btnGetAllCustomer").click(function () {
    getAllCustomer();
});









// customer save funtion
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








function getAllCustomer() {
    //clear all tbody data before add
    $("#tblCustomer").empty();

    $.ajax({
        url: 'http://localhost:8080/carRental/customer',
        dataType: "json",
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (response) {
            let customers = response.data;
            for (let i in customers) {
                let cus = customers[i];
                let customerID = cus.customerID;
                let name = cus.name;
                let address = cus.address;
                let email = cus.email;
                let contactNo = cus.contactNO;
                let licenceNO = cus.licenceNO;
                let row = `<tr><td>${customerID}</td><td>${name}</td><td>${address}</td><td>${email}</td><td>${contactNo}</td><td>${licenceNO}<td></td></tr>`;
                $("#tblCustomer").append(row);
            }


            //bindTrEventsCustomer();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}