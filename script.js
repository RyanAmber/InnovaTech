localStorage.clear();

document.getElementById('signin-form').addEventListener('submit', async function(e) {
  e.preventDefault();

  const inputUsername = document.querySelector('[name="username"]').value;
  const inputPassword = document.querySelector('[name="password"]').value;

  try {
    const res = await fetch('/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        username: inputUsername,
        password: inputPassword
      })
    });

    const result = await res.json();

    if (result.success) {
  const role = result.role;
  localStorage.setItem('username', inputUsername);
  if (role === "Teacher") {
    window.location.href = 'TeacherDashboard.html';
  } else if (role === "Student") {
    window.location.href = 'StudentDashboard.html';
  }
}
  } catch (error) {
    console.error(error);
    document.getElementById('message').textContent = 'Error processing login';
  }
});
