localStorage.clear();
document.getElementById('signin-form').addEventListener('submit', function(e) {
  e.preventDefault();

  fetch('UserData.txt')
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
    const validUser = users.find(u => u.username === inputUsername && u.password === inputPassword&&(u.role==="Teacher"||u.role==="Student"));
    if(validUser) {
      console.log('User role is:', validUser.role);
      localStorage.setItem("username", inputUsername); 
      if (validUser.role==="Teacher"){
        window.location.href = 'TeacherDashboard.html';
      }else if(validUser.role==="Student"){
        window.location.href = 'Studentdashboard.html';
      }
    } else {
      document.getElementById('message').textContent = "Incorrect user data";
    }
  })
  .catch(() => {
    document.getElementById('message').textContent = 'Error loading users data';
  });

});
