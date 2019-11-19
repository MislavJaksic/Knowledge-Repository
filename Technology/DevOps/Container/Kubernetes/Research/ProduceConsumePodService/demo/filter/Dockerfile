FROM jfloff/alpine-python:3.7

COPY app /app
WORKDIR /app

RUN pip install -r requirements.txt

EXPOSE 5002

CMD ["python", "server.py"]
