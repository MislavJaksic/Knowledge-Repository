import os
from random import randrange
import requests
from flask import Flask, jsonify

app = Flask(__name__)
msgs = []

@app.route("/")
def generate():
    number = randrange(1, 101)
    ADDRESS = os.environ.get("ADDRESS")
    payload = {"number": str(number)}

    requests.post(ADDRESS, json=payload)

    msgs.append(payload)

    return jsonify([msg for msg in msgs])


if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=5001)
