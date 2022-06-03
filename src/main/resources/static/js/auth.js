const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");

sign_up_btn.addEventListener("click", () => {
  container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
  container.classList.remove("sign-up-mode");
});
$(document).ready(function($) {
  $('#password-signup').passtrength({
    minChars: 8,
    passwordToggle: true,
    tooltip: true
  });
  $('#confirm-password-signup').keyup(function(){
    if ($('#confirm-password-signup').val() != $('#password-signup').val()) {
      $('#confirm-password-error-message').text('Authentication password is incorrect');
      $('#btn-signup').prop('disabled', true);
    }
    else{
      $('#confirm-password-error-message').text('');
      $('#btn-signup').prop('disabled', false);
    }
  });
});
