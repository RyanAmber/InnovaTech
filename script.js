document.addEventListener('DOMContentLoaded', () => {
  const signinForm = document.getElementById('signin-form');
  const message = document.getElementById('message');
  const signupButton = document.getElementById('signup-button');

  // Handle sign-in
  signinForm.addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();

    // Fake validation logic
    if (email === "user@example.com" && password === "password123") {
      message.style.color = "green";
      message.textContent = "Sign-in successful!";
      // Optionally redirect to a dashboard page
      // window.location.href = "dashboard.html";
    } else {
      message.style.color = "red";
      message.textContent = "Account not found. Redirecting to Sign Up...";
      setTimeout(() => {
        window.location.href = "sign-up.html";
      }, 1500); // delay redirect so user sees the message
    }
  });

  // Handle sign-up button click
  signupButton.addEventListener('click', function(event) {
    event.preventDefault();
    window.location.href = "sign-up.html";
  });
});
