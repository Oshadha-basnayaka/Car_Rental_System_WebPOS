getAllCars();


$("#btnGetAllCar").click(function () {
    getAllCars();
});




//bind tr events for getting back data of the rows to text fields
function bindTrEvents() {
    $('#tblCar>tr').click(function () {
        //get the selected rows data
        let id = $(this).children().eq(0).text();
        let regNO = $(this).children().eq(1).text();
        let brand = $(this).children().eq(2).text();
        let type = $(this).children().eq(3).text();
        let passenger = $(this).children().eq(4).text();
        let color = $(this).children().eq(5).text();
        let Transmission = $(this).children().eq(6).text();
        let fuel = $(this).children().eq(7).text();
        let extraMilagePrice = $(this).children().eq(8).text();
        let curentMilage = $(this).children().eq(9).text();

        let wavierPayment = $(this).children().eq(10).text();
        let availability = $(this).children().eq(11).text();

        let freeMileageDaily = $(this).children().eq(12).text();
        let freeMileageDailyPrice = $(this).children().eq(13).text();

        let freeMileageMonthly = $(this).children().eq(14).text();
        let freeMileageMonthlyPrice = $(this).children().eq(15).text();


        //set the selected rows data to the input fields
        $("#txtCarId").val(id);
        $("#txtCarRegNum").val(regNO);
        $("#txtDriverName").val(brand);
        $("#txtDriverEmail").val(type);
        $("#txtCarNumPassengers").val(passenger);
        $("#txtCarColour").val(color);
        $("#txtCarTransmission").val(Transmission);
        $("#txtCarFuel").val(fuel);
        $("#txtExtraKMPrice").val(extraMilagePrice);
        $("#txtcurrentMileage").val(curentMilage);

        $("#txtWavierPayment").val(wavierPayment);
        $("#txtAvailability").val(availability);

        $("#txtDailyRate").val(freeMileageDaily);
        $("#txtCarDayPrice").val(freeMileageDailyPrice);

        $("#txtFreeMileage").val(freeMileageMonthly);
        $("#txtCarMonthlyPrice").val(freeMileageMonthlyPrice);
    })
}






function getAllCars() {
    //clear all tbody data before add
    $("#tblCar").empty();

    $.ajax({
        url: 'http://localhost:8080/carRental/car',
        dataType: "json",
        headers:{
            Auth:"user=admin,pass=admin"
        },
        success: function (response) {
            let cars = response.data;
            for (let i in cars) {
                let ca = cars[i];
                let carID = ca.carID;
                let regNO = ca.regNO;
                let brand = ca.brand;
                let type = ca.type;
                let passenger = ca.passenger;
                let color = ca.color;
                let transmissionType = ca.transmissionType;
                let fuelType = ca.fuelType;
                let extraMileagePrice = ca.extraMileagePrice;
                let currentMileage = ca.currentMileage;

                let wavierPayment = ca.wavierPayment;
                let availability = ca.availability;

                let freeMileageDaily = ca.freeMileageDaily;
                let freeMileageDailyPrice = ca.freeMileageDailyPrice;

                let freeMileageMonthly = ca.freeMileageMonthly;
                let freeMileageMonthlyPrice = ca.freeMileageMonthlyPrice;
                let row = `<tr><td>${carID}</td><td>${regNO}</td><td>${brand}</td><td>${type}</td><td>${passenger}</td><td>${color}<td>${transmissionType}</td><td>${fuelType}</td><td>${extraMileagePrice}</td><td>${currentMileage}</td><td>${wavierPayment}</td><td>${availability}</td><td>${freeMileageDaily}</td><td>${freeMileageDailyPrice}</td><td>${freeMileageMonthly}</td><td>${freeMileageMonthlyPrice}</td></td></tr>`;
                $("#tblCar").append(row);
            }


           bindTrEvents();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}





$("#btnsaveCar").click(function () {
    var formData  = new FormData($("#carform")[0]);
    $.ajax({
        url: 'http://localhost:8080/carRental/car',
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