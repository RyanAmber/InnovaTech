document.getElementById('signin-form').addEventListener('submit', function (e) {
  e.preventDefault(); // Prevents the default form submission behavior

  const username = document.getElementById('name').value;
  const password = document.getElementById('password').value;

  if (username === 'admin' && password === 'pass123') {
    window.location.href = 'dashboard.html';
  } else {
    window.location.href = 'dashboard.html';
    //document.getElementById('message').textContent = 'Invalid credentials';
  }
});
