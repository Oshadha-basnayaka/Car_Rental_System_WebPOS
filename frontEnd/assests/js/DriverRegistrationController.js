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
            }


             bindTrEvents();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}

function updateDriver(id) {
    if (searchCustomer(id) == undefined) {
        alert("No such Customer..please check the ID");
    } else {
        let consent = confirm("Do you really want to update this customer.?");
        if (consent) {
            let customer = searchCustomer(id)[0];
            //if the customer available can we update.?
            console.log(customer);
            let customerName = $("#txtCustomerName").val();
            let customerAddress = $("#txtCustomerAddress").val();
            let customerSalary = $("#txtCustomerSalary").val();
            customer.id = id;
            customer.name = customerName;
            customer.address = customerAddress;
            customer.salary = customerSalary;

            $.ajax({
                url: BASE_URL + 'customer',
                method: 'put',
                headers:{
                    Auth:"user=admin,pass=admin"
                },
                contentType: "application/json",
                data: JSON.stringify(customer),
                success: function (resp) {
                    alert(resp.message);
                    getAllCustomers();
                    clearCustomerInputFields();
                },
                error: function (error) {
                    alert(error.responseJSON.message);
                }
            });
        }
    }

}






//bind tr events for getting back data of the rows to text fields
function bindTrEvents() {
    $('#tblDriver>tr').click(function () {
        //get the selected rows data
        let id = $(this).children().eq(0).text();
        let licenceNO = $(this).children().eq(1).text();
        let name = $(this).children().eq(2).text();
        let email = $(this).children().eq(3).text();
        let contactNo = $(this).children().eq(4).text();

        //set the selected rows data to the input fields
        $("#txtDriverId").val(id);
        $("#txtDriverLicenceNo").val(licenceNO);
        $("#txtDriverName").val(name);
        $("#txtDriverEmail").val(email);
        $("#txtDriverContact").val(contactNo);
    })
}