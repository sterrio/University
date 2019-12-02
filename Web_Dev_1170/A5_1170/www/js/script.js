// add on click event to the button,
var messageButton = document.getElementById("showMessageFormBtn");
// adding content fields
var content = document.getElementById("content");
// init for error
var formError = false

// Creating attribute and function to handle when the button is clicked
messageButton.setAttribute("onclick", "buttonClicked()")

function buttonClicked(){
    messageButton.setAttribute("disabled", "true")
    content.innerHTML += '<h2>Full Name:</h2><input id="fullName" type="text" /><h2>Email address (must end with .ca):</h2><input id="emailAddr" oninput = "emailInput(this)" type="text" /><h2>Your message:</h2><textarea id="messageContent"></textarea><br /><button onclick="sendMessage()" id="sendMessage">Send Message Now</button>'
}

// Saving blank state for later
var initialInnerContent = content.innerHTML;

// email verification
function emailInput (emailField){
    const emailValid = /\S+@\S+\.ca/.test(emailField.value)
    if (!emailValid){
        emailField.style.border = "1px solid red"
        
    }else{
        emailField.style.border = document.getElementById("fullName").style.border
    }
}

// When the send message button is clicked, catch errors or return confirmation
function sendMessage() {
    var name = document.getElementById("fullName")
    var email = document.getElementById("emailAddr")
    var message = document.getElementById("messageContent")
    
    // testing to see if all fields are acceptable, using regex to see if email is formatted correct
    const emailValid = /\S+@\S+\.ca/.test(email.value)
    if (name.value === "" || email.value === "" || !emailValid || message.value === "") {
        if (!emailValid){
            email.style.borderColor = "red"
            email.style.borderWidth = "1px"
        }
      if (!formError){  
        formError = true;  
        content.innerHTML += '<br /><i><p style="color: red"> * All fields of this form must have content. Please add your name, email and message and then submit the form. </p></i>'
      }
    //If all fields are accepted
    } else {
        const successMessage = "Name: " + name.value + "\n" + "Email: " + email.value + "\n" + "Message: " + message.value;
        alert(successMessage);
        // clean everything up afterwards (code freezes before this)
        content.innerHTML = initialInnerContent
        formError = false
    }
  }

