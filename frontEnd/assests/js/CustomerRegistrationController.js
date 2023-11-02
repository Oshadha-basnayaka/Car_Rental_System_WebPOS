// let baseUrl : string = "http://localhost:8080/backEnd_war/";
getAllCustomer();

//get all customer event
$("#btnGetAllCustomer").click(function () {
    getAllCustomer();
});



//bind tr events for getting back data of the rows to text fields
function bindTrEvents() {
    $('#tblDriver>tr').click(function () {
        //get the selected rows data
        let id = $(this).children().eq(0).text();
        let name = $(this).children().eq(1).text();
        let address = $(this).children().eq(2).text();
        let email = $(this).children().eq(3).text();
        let contactNo = $(this).children().eq(4).text();
        let licenseNo = $(this).children().eq(5).text();

        //set the selected rows data to the input fields
        $("#txtDriverId").val(id);
        $("#txtDriverLicenceNo").val(name);
        $("#txtDriverName").val(address);
        $("#txtDriverEmail").val(email);
        $("#txtDriverContact").val(contactNo);
        $("#txtDriverContact").val(licenseNo);
    })
}





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


            bindTrEvents();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}