from flask import Flask, request, jsonify

app = Flask(__name__)
msgs = []

@app.route("/", methods=["GET"])
def get_filtered():
    return jsonify([msg for msg in msgs])

@app.route("/filter", methods=["POST"])
def filter():
    json = request.json
    number = json["number"]

    if int(number) >= 50:
        msgs.append(json)

    print(msgs)

    return jsonify({"number": str(number)})


if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=5002)
