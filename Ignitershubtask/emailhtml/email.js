function emailSend(){
    var userName = document.getElementById('name').value;
    var semester = document.getElementById('semester').value;
    var branch = document.getElementById('branch').value;
    var roll_number = document.getElementById('roll_number').value;
    var image = document.getElementById('image').value;

    var messageBody = "Name"+ userName+"<br/>Semster"+semester+"<br/>branch"+branch+"<br/>roll_number"+roll_number+"<br/>image"+image;

    Email.send({
        Host : "smtp.elasticemail.com",
        Username : "patelkuldeep1747@gmail.com",
        Password : "23E7444198A0644A60583D63C68A46972EC6",
        To : 'hr@ignitershub.com',
        From : "patelkuldeep1747@gmail.com",
        Subject : "This is the subject",
        Body : messageBody
    }).then(
      message => {
        if(messageBody=='OK'){
            swal("Sucussful", "You clicked the button!", "success");
        }
        else{
            swal("Error", "You clicked the button!", "error");
        }
      }
    );
}
