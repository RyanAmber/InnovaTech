document.getElementById('signin-form').addEventListener('submit', function(e) {
  e.preventDefault();

  fetch('users.txt')
  .then(response => response.text())
  .then(text => {
    const lines = text.split('\n').map(line => line.trim()).filter(Boolean);
    const users = lines.map(line => {
      const parts = line.split(' ');
      return {
        username: parts[0],
        password: parts[1],
        role: parts[2]
      };
    });

    const inputUsername = document.getElementById('name').value;
    const inputPassword = document.getElementById('password').value;
    const validUser = users.find(u => u.username === inputUsername && u.password === inputPassword);

    if(validUser) {
      console.log('User role is:', validUser.role);
      // For example, you could redirect differently based on role
      window.location.href = 'dashboard.html';
    } else {
      document.getElementById('message').textContent = u.username;
      setTimeout(function(){
        window.location.href = 'dashboard.html';
      },2000);
    }
  })
  .catch(() => {
    document.getElementById('message').textContent = 'Error loading users data';
  });

});
