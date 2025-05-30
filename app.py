from flask import Flask, request, jsonify, render_template
from flask_cors import CORS
import os

app = Flask(__name__)
CORS(app)

USER_FILE = 'UserData.txt'
LOG_FILE = 'Logins.txt'

# Ensure user file exists
if not os.path.exists(USER_FILE):
    open(USER_FILE, 'a').close()

@app.route('/')
def login_page():
    return render_template('index.html')

@app.route('/signup-page')
def signup_page():
    return render_template('sign-up.html')

@app.route('/signup', methods=['POST'])
def signup():
    data = request.get_json()
    username = data.get('username')
    password = data.get('password')
    team = data.get('team')  # This acts as the role

    if not username or not password or not team:
        return jsonify({'success': False, 'message': 'Missing fields'}), 400

    try:
        with open(USER_FILE, 'r') as f:
            for line in f:
                existing_user, *_ = line.strip().split(',')
                if existing_user == username:
                    return jsonify({'success': False, 'message': 'Username already exists'}), 409

        with open(USER_FILE, 'a') as f:
            f.write(f"{username},{password},{team}\n")

        return jsonify({'success': True, 'message': 'User signed up successfully'})
    except Exception as e:
        return jsonify({'success': False, 'message': str(e)}), 500

@app.route('/login', methods=['POST'])
def login():
    data = request.get_json()
    username = data.get('username')
    password = data.get('password')

    try:
        with open(USER_FILE, 'r') as f:
            for line in f:
                u, p, role = line.strip().split(',')
                if u == username and p == password:
                    with open(LOG_FILE, 'a') as log:
                        log.write(f"{username} logged in successfully\n")
                    return jsonify({'success': True, 'message': 'Login successful', 'role': role})

        return jsonify({'success': False, 'message': 'Invalid credentials'}), 401
    except Exception as e:
        return jsonify({'success': False, 'message': str(e)}), 500

@app.route('/welcome')
def welcome_page():
    return "<h1>Welcome!</h1><p>You are logged in.</p>"

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
