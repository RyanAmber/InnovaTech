from flask import Flask, request, jsonify, render_template
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

USER_FILE = 'UserData.txt'

@app.route('/')
def signup_page():
    return render_template('sign-up.html')

@app.route('/signup', methods=['POST'])
def login():
    data = request.get_json()
    username = data.get('username')
    password = data.get('password')

    # Check credentials from UserData.txt
    try:
        with open(USER_FILE, 'r') as f:
            users = f.readlines()
            for line in users:
                u, p, _ = line.strip().split(',')
                if u == username and p == password:
                    # ✅ Log successful login
                    with open('Logins.txt', 'a') as log:
                        log.write(f"{username} logged in successfully\n")

                    return jsonify({'success': True, 'message': 'Login successful'})
            return jsonify({'success': False, 'message': 'Invalid credentials'}), 401
    except Exception as e:
        return jsonify({'success': False, 'message': str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
