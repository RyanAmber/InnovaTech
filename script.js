document.getElementById('loginForm').addEventListener('submit', function (e) {
  e.preventDefault();

  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;

  // Fake login credentials — only for demo purposes
  if (username === 'admin' && password === 'pass123') {
    window.location.href = 'dashboard.html';
  } else {
    window.location.href = 'dashboard.html';
    //alert('Invalid username or password.');
  }
});
