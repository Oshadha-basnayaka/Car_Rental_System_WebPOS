// let baseUrl : string = "http://localhost:8080/backEnd_war/";

getAllDrivers();


// events


//update driver  btn event
$("#btnUpdateDriver").click(function () {
    let id = $("#txtDriverId").val();
    updateDriver(id);
    clearCustomerInputFields();
});


//get all driver event
$("#btnGetAllDriver").click(function () {
    getAllDrivers();
});

//delete btn event
$("#btnDeleteDriver").click(function () {
    let id = $("#txtDriverId").val();

    let consent = confirm("Do you want to delete.?");
    if (consent) {
        let response = deleteDriver(id);
        if (response) {
            alert("Driver Deleted");
            clearCustomerInputFields();
            getAllDrivers();
        } else {
            alert("Driver Not Removed..!");
        }
    }


});






// function


$("#btnSaveDriver").click(function () {
    var formData  = new FormData($("#driverform")[0]);
    $.ajax({
        url: 'http://localhost:8080/carRental/driver',
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



function getAllDrivers() {
    //clear all tbody data before add
    $("#tblDriver").empty();

    $.ajax({
        url: 'http://localhost:8080/carRental/driver',
        dataType: "json",
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (response) {
            let drivers = response.data;
            for (let i in drivers) {
                let dri = drivers[i];
                let driverID = dri.driverID;
                let drivingLicenceNo = dri.drivingLicenceNo;
                let driverName = dri.driverName;
                let email = dri.email;
                let contactNo = dri.contactNo;
                let frontImage = dri.frontImage;
                let backImage = dri.backImage;
                let row = `<tr><td>${driverID}</td><td>${drivingLicenceNo}</td><td>${driverName}</td><td>${email}</td><td>${contactNo}</td><td>${frontImage}<td>${backImage}</td></td></tr>`;
                $("#tblDriver").append(row);


                 bindTrEventsDriver();
            }



        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}



function deleteDriver(id) {
    $.ajax({
        url:'http://localhost:8080/carRental/driver?driverID=' + id,

        method: 'delete',
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (resp) {
            alert(resp.message);
            getAllDrivers();
            clearCustomerInputFields()
            return true;
        },
        error: function (error) {
            alert(error.responseJSON.message);
            return false;
        }
    });
}








//bind tr events for getting back data of the rows to text fields

function bindTrEventsDriver() {

    $('#tblDriver>tr').click(function () {


        //get the selected rows data
        let id = $(this).children().eq(0).text();
        let name = $(this).children().eq(1).text();
        let email = $(this).children().eq(2).text();
        let contactNo = $(this).children().eq(3).text();
        let licenseNo = $(this).children().eq(4).text();

        //set the selected rows data to the input fields
        $("#txtDriverId").val(id);
        $("#txtDriverName").val(name);
        $("#txtDriverEmail").val(email);
        $("#txtDriverContact").val(contactNo);
        $("#txtDriverLicenceNo").val(licenseNo);
    })
}


