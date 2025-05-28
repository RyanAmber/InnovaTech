from flask import Flask, request, jsonify
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

USER_FILE = 'UserData.txt'

@app.route('/signup', methods=['POST'])
def signup():
    data = request.get_json()
    username = data.get('username')
    password = data.get('password')
    team = data.get('team')

    if not username or not password or not team:
        return jsonify({'success': False, 'message': 'Missing fields'}), 400

    try:
        with open(USER_FILE, 'a') as f:
            f.write(f"{username},{password},{team}\n")
        return jsonify({'success': True, 'message': 'User signed up'})
    except Exception as e:
        return jsonify({'success': False, 'message': str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0')
