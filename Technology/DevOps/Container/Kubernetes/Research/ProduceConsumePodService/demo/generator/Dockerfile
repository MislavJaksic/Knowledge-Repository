FROM jfloff/alpine-python:3.8-slim

COPY app /app
WORKDIR /app

RUN pip install -r requirements.txt

EXPOSE 5001

CMD ["python", "server.py"]
