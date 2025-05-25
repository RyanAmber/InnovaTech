document.addEventListener('DOMContentLoaded', () => {
  const signinForm = document.getElementById('signin-form');
  const message = document.getElementById('message');
  const signupButton = document.getElementById('signup-button');

  signinForm.addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();

    fetch('http://localhost:4567/api/signin', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ username: email, password: password })
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        message.style.color = "green";
        message.textContent = `Welcome! Role: ${data.role}`;
        // Optionally redirect based on role
        window.location.href = "dashboard.html";
      } else {
        message.style.color = "red";
        message.textContent = "Login failed. Please check your credentials.";
      }
    })
    .catch(error => {
      console.error('Error:', error);
      message.style.color = "red";
      message.textContent = "Server error. Try again later."+error;
    });
  });

  signupButton.addEventListener('click', function(event) {
    event.preventDefault();
    window.location.href = "sign-up.html";
  });
});
