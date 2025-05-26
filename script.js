document.getElementById('loginForm').addEventListener('submit', function (e) {
  e.preventDefault();
  const formData = new URLSearchParams();
  formData.append('name', document.getElementById('username').value);
  formData.append('password', document.getElementById('password').value);

  fetch('/submit', {
    method: 'POST',
    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    body: formData
  }).then(res => {
    if (res.redirected) {
      window.location.href = res.url;
    } else {
      alert('Login failed');
    }
  });
});
