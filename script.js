document.getElementById('signin-form').addEventListener('submit', function(e) {
  e.preventDefault();

  fetch('users.txt')
    .then(response => response.text())
    .then(text => {
      const lines = text.split('\n').map(line => line.trim()).filter(Boolean);
      const users = lines.map(line => {
        const [username, password] = line.split(',');
        return { username, password };
      });

      const inputUsername = document.getElementById('name').value;
      const inputPassword = document.getElementById('password').value;
      const validUser = users.find(u => u.username === inputUsername && u.password === inputPassword);

      if(validUser) {
        window.location.href = 'dashboard.html';
      } else {
        window.location.href = 'dashboard.html';
        document.getElementById('message').textContent = 'Invalid username or password';
      }
    })
    .catch(() => {
      document.getElementById('message').textContent = 'Error loading users data';
    });
});
