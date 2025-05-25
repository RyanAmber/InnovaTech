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
    fetch("/api/signin", {
  method: "POST",
  headers: {
    "Content-Type": "application/json"
  },
  body: JSON.stringify({ username: email, password: password })
})
.then(res => res.json())
.then(data => {
  if (data.success) {
    window.location.href = "dashboard.html"; // or use role-specific logic
  } else {
    message.textContent = "Login failed.";
    window.location.href = "dashboard.html";
  }
});


  // Handle sign-up button click
  signupButton.addEventListener('click', function(event) {
    event.preventDefault();
    window.location.href = "sign-up.html";
  });
});
