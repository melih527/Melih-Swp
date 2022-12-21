from flask import Flask, jsonify, request, render_template
from flask_restful import Resource, Api
import wahl

app = Flask(__name__, template_folder='templates')
# creating an API object
api = Api(app)



class statistiken(Resource):
    def get(self):
        list = {}
        with open('ergebnisse.txt', 'r') as file:
            list = file.read()
        return list
api.add_resource(statistiken, '/get')



if __name__ == '__main__':
    app.run(debug=True)